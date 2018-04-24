import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteProduct extends JPanel {
	
	JTextField idField;
	JButton btnDeleteProduct;
	private JLabel error;
	String id,err="Enter product id!";
	/**
	 * Create the panel.
	 */
	public deleteProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblUpdateProduct = new JLabel("DELETE PRODUCT");
		lblUpdateProduct.setBounds(319, 84, 182, 21);
		lblUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblUpdateProduct);
		
		JLabel lblProductName = new JLabel("Product ID");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(253, 156, 124, 21);
		add(lblProductName);
		
		idField = new JTextField();
		idField.setBounds(449, 158, 136, 20);
		add(idField);
		idField.setColumns(10);
		
		btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idField.getText().equals(""))
				{
					error.setText(err);
				}
				else
				{
					error.setText("");
					id=idField.getText().trim();
					DB.deleteProductToDB(id);
					idField.setText("");
				}
			}
		});
		btnDeleteProduct.setBounds(449, 219, 136, 23);
		add(btnDeleteProduct);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(349, 277, 217, 14);
		add(error);
		
	}

}
