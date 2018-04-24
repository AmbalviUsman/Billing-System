import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class updateProduct extends JPanel {
	
	JTextField idField;
	JTextArea descField;
	JButton btnUpdateProduct;
	JComboBox<String> company;
	private JTextField quanField;
	JLabel error ;
	String id,detail,comp;
	int quan;
	String err="Enter product id and quantity";
	/**
	 * Create the panel.
	 */
	public updateProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblUpdateProduct = new JLabel("UPDATE PRODUCT");
		lblUpdateProduct.setBounds(328, 45, 182, 21);
		lblUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblUpdateProduct);
		
		JLabel lblProductName = new JLabel("Product ID");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(246, 136, 124, 21);
		add(lblProductName);
		
		JLabel lblProductDescription = new JLabel("Product detail\r\n");
		lblProductDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductDescription.setBounds(246, 168, 139, 21);
		add(lblProductDescription);
		
		idField = new JTextField();
		idField.setBounds(449, 137, 136, 20);
		add(idField);
		idField.setColumns(10);
		
		descField = new JTextArea();
		descField.setBounds(449, 168, 136, 58);
		add(descField);
		JScrollPane scroll = new JScrollPane(descField);
		scroll.setBounds(449, 168, 136, 58);
		add(scroll);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompany.setBounds(246, 241, 124, 21);
		add(lblCompany);
		idField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				id=idField.getText().trim()+e.getKeyChar();
				ArrayList<String> data=DB.searchP(id);
				if(data.size()==3)
					{
						descField.setText(data.get(0));
						quanField.setText(data.get(2));
						switch(data.get(1))
						{
							case "General":company.setSelectedIndex(0);break;
							case "Mats & Rugs":company.setSelectedIndex(1);break;
							case "N/S & Electric":company.setSelectedIndex(2);break;
						}
					}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(quanField.getText().equals("")||idField.getText().equals(""))
				{
					error.setText(err);
				}
				else
				{
					error.setText("");
					id=idField.getText().trim();
					quan=Integer.parseInt(quanField.getText().trim());
					detail=descField.getText().trim();
					comp=company.getSelectedItem().toString();
					DB.updateProductToDB(id, detail, comp, quan);
					idField.setText("");
					quanField.setText("");
					descField.setText("");
				}
			}
		});
		btnUpdateProduct.setBounds(449, 338, 136, 23);
		add(btnUpdateProduct);
		
		quanField = new JTextField();
		quanField.setColumns(10);
		quanField.setBounds(449, 278, 136, 20);
		add(quanField);
		
		JLabel lblQuantity = new JLabel("Items available");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(246, 276, 124, 21);
		add(lblQuantity);
		
		company = new JComboBox<String>();
		company.setBounds(449, 243, 136, 20);
		add(company);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(299, 95, 286, 14);
		add(error);
		company.addItem("General");
		company.addItem("Mats & Rugs");
		company.addItem("N/S & Electric");
		
	}

}
