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

public class searchCashier extends JPanel {
	
	JTextField idField;
	JButton btnUpdateProduct;
	private JLabel error;
	String id,err="Enter product id!";
	/**
	 * Create the panel.
	 */
	public searchCashier() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblsearch = new JLabel("SEARCH CASHIER");
		lblsearch.setBounds(319, 84, 182, 21);
		lblsearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblsearch);
		
		JLabel lbluser = new JLabel("User name");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbluser.setBounds(253, 156, 124, 21);
		add(lbluser);
		
		idField = new JTextField();
		idField.setBounds(449, 158, 136, 20);
		add(idField);
		idField.setColumns(10);
		
		btnUpdateProduct = new JButton("Search");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idField.getText().equals(""))
				{
					error.setText(err);
				}
				else
				{
					error.setText("");
					id=idField.getText().trim();
					DB.searchCashier(id);
					idField.setText("");
				}
			}
		});
		btnUpdateProduct.setBounds(449, 219, 136, 23);
		add(btnUpdateProduct);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(349, 277, 217, 14);
		add(error);
		
	}

}
