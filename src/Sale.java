import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Sale extends JPanel {
	private JTable sale;
	private JTextField date;
	JComboBox<String> comp ;
	String com,dt;
	static DefaultTableModel dtm;
	ArrayList<String> print=new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public Sale() {
		setLayout(null);
		
		String [] header={"Date","Product ID","Company","Sale"};
		dtm= new DefaultTableModel(header, 0);  
		sale = new JTable(dtm);
		sale.setBounds(244, 69, 494, 379);
		add(sale);
		JScrollPane s=new JScrollPane(sale);
		s.setBounds(244, 69, 494, 379);
		add(s);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object data[]=new Object[dtm.getColumnCount()*dtm.getRowCount()];
				int x=0;
				long total=0;
				for(int row=0;row<dtm.getRowCount();row++)
				{
					for(int col=0;col<dtm.getColumnCount();col++)
					{
						data[x]=sale.getValueAt(row, col);
						if(col==3)
							{total+=Long.parseLong((String) data[x]);}
						x++;
					}
				}
				pdfGenerator.makePdf2(data,total);
			}
		});
		btnPrint.setBounds(244, 472, 118, 46);
		add(btnPrint);
		
		JRadioButton ds = new JRadioButton("Daily Sale");
		ds.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ds.setBounds(62, 69, 109, 23);
		add(ds);
		ds.setSelected(true);
		
		JRadioButton ms = new JRadioButton("Monthly Sale");
		ms.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ms.setBounds(62, 112, 144, 23);
		add(ms);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(62, 178, 75, 14);
		add(lblDate);
		
		date = new JTextField();
		date.setBounds(62, 199, 86, 20);
		add(date);
		date.setColumns(10);
		
		JLabel lblMm = new JLabel("yyyy/mm/dd");
		lblMm.setBounds(149, 202, 85, 14);
		add(lblMm);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dt=date.getText().trim();
				com=comp.getSelectedItem().toString();
				if(ds.isSelected())
					dailySale(dt,com);
				else
					monthlySale(dt,com);
			}
		});
		btnLoad.setBounds(62, 328, 89, 23);
		add(btnLoad);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompany.setBounds(62, 230, 109, 27);
		add(lblCompany);
		
		comp = new JComboBox<String>();
		comp.setBounds(62, 261, 86, 20);
		add(comp);
		comp.addItem("All");
		comp.addItem("General");
		comp.addItem("Mats & Rugs");
		comp.addItem("N/S & Electric");
		
		
		
		ms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ds.setSelected(false);
			}
		});
		ds.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				ms.setSelected(false);
			}
		});
	}
	
	public static void dailySale(String dt,String com)
	{
		ArrayList<String> sl=new ArrayList<String>();
		sl=DB.getSale(dt, com);
		String x1,x2,x3,x4;
		dtm.setRowCount(0);
		int sz=sl.size()/4;
		for(int x=0;x<sz;x++)
		{
			x1=sl.get(0);sl.remove(0);
			x2=sl.get(0);sl.remove(0);
			x3=sl.get(0);sl.remove(0);
			x4=sl.get(0);sl.remove(0);
			
			dtm.addRow(new Object[]{x1,x2,x3,x4});
		}
	}
	public static void monthlySale(String dt,String com)
	{
		String date[]=dt.split("/");
		String s[]={"","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		ArrayList<String> sl=new ArrayList<String>();
		String ndt;
		dtm.setRowCount(0);
		for(int x=1;x<=31;x++)
		{
			ndt=date[0]+"/"+date[1]+"/"+s[x].trim();
			sl=DB.getSale(ndt, com);
			String x1,x2,x3,x4;
			
			int sz=sl.size()/4;
			for(int i=0;i<sz;i++)
			{
				x1=sl.get(0);sl.remove(0);
				x2=sl.get(0);sl.remove(0);
				x3=sl.get(0);sl.remove(0);
				x4=sl.get(0);sl.remove(0);
				
				dtm.addRow(new Object[]{x1,x2,x3,x4});
			}
		}
		
		
		
	}
}
