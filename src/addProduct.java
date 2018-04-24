import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addProduct extends JPanel {
	
	JTextField idField;
	JTextArea descField;
    JTextField quanField;
    JLabel error;
	JComboBox<String> company;
	String id,detail,comp;
	int quan;
	String err="Enter product id and quantity";
	/**
	 * Create the panel.
	 */
	public addProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblAddProduct = new JLabel("ADD PRODUCT");
		lblAddProduct.setBounds(328, 45, 115, 21);
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblAddProduct);
		
		JLabel lblProductName = new JLabel("Product ID");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(246, 136, 124, 21);
		add(lblProductName);
		
		JLabel lblProductDescription = new JLabel("Product Details\r\n");
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
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
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
					DB.addProductToDB(id, detail, comp, quan);
					idField.setText("");
					quanField.setText("");
					descField.setText("");
				}
			}
		});
		btnAddProduct.setBounds(449, 334, 136, 23);
		add(btnAddProduct);
		
		quanField = new JTextField();
		quanField.setColumns(10);
		quanField.setBounds(449, 274, 136, 20);
		add(quanField);
		
		JLabel lblQuantity = new JLabel("Items available");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(246, 273, 124, 21);
		add(lblQuantity);
		
		company = new JComboBox<String>();
		company.setBounds(449, 243, 136, 20);
		add(company);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(339, 92, 265, 14);
		add(error);
		company.addItem("General");
		company.addItem("Mats & Rugs");
		company.addItem("N/S & Electric");
		
	}
}
