import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addCashier extends JPanel {
	
	JTextField userField;
	JButton btnAddCashier;
	private JPasswordField passwordField;
	private JLabel error;
	String err="Enter username and passowrd";
	String user,pass;
	/**
	 * Create the panel.
	 */
	public addCashier() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblAddCashier = new JLabel("ADD CASHIER");
		lblAddCashier.setBounds(328, 45, 182, 21);
		lblAddCashier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblAddCashier);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(246, 104, 124, 21);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(246, 136, 124, 21);
		add(lblPassword);
		
		userField = new JTextField();
		userField.setBounds(436, 106, 147, 20);
		add(userField);
		userField.setColumns(10);
		
		btnAddCashier = new JButton("Add Cashier");
		btnAddCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user=userField.getText().trim();
				pass=passwordField.getText().toString().trim().toLowerCase();
				if(user.equals("")||pass.equals(""))
					error.setText(err);
				else
				{
					error.setText("");
					DB.addCashier(user,pass);
					userField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnAddCashier.setBounds(436, 194, 147, 23);
		add(btnAddCashier);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(436, 138, 147, 19);
		add(passwordField);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(328, 241, 201, 14);
		add(error);
		
	}

}
