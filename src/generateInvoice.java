

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Toolkit;

public class generateInvoice extends JFrame implements ActionListener{

	private JPanel contentPane;
	int jp;
	ArrayList<JPanel> panels=new ArrayList<JPanel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateInvoice frame = new generateInvoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public generateInvoice() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Working Directory\\fianl project with sql\\Bill\\logo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850,600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmGenerateInvoice = new JMenuItem("Generate Invoice");
		mnNewMenu.add(mntmGenerateInvoice);
		mntmGenerateInvoice.addActionListener(this);
		
		JMenuItem mntmSearch = new JMenuItem("Search Product");
		mnNewMenu.add(mntmSearch);
		mntmSearch.addActionListener(this);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnNewMenu.add(mntmLogout);
		mntmLogout.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		searchProduct sp=new searchProduct();
		
		panels.add(new Invoice());
		panels.add(new searchProduct());
		getContentPane().add(panels.get(0));
		jp=0;
		this.setTitle("Generate Invoice");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Search Product"))
		{
			this.remove(panels.get(jp));
			this.revalidate();
			this.repaint();
			getContentPane().add(panels.get(1));
			jp=1;
			this.setVisible(true);
			this.setTitle("Search Product");
			
		}
		else if(e.getActionCommand().equals("Generate Invoice"))
		{
			this.remove(panels.get(jp));
			this.revalidate();
			this.repaint();
			getContentPane().add(panels.get(0));
			this.setVisible(true);
			jp=0;
			this.setTitle("Generate Invoice");
		}
		
		else if(e.getActionCommand().equals("Logout"))
		{
			this.dispose();
		}
	}
}
