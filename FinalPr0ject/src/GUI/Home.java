package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Home extends JFrame implements ActionListener, MouseListener, MenuListener {
Vector<User> user;

	JPanel midPanel, botPanel, userTableP;
	JLabel KodeLbl, NamaLbl, HargaLbl, StokLbl;
	JButton backBtn;
	JMenuBar homeMenuBar;
	JMenu settings;

	JTable userTable;
	JScrollPane tableScrollPane;

	public Home(Vector<User> user, String loginKode) {

		
		this.user = user;

		
		int idx = -1;
		
		for(int x=0;x<user.size();x++) {
			if(user.get(x).getKode().equals(loginKode)) {
				idx = x;
				break;
			}
		}

		String Kode = user.get(idx).getKode();
		String Nama = user.get(idx).getNama();
		String Harga = user.get(idx).getHarga();
		String Stok = user.get(idx).getStok();
		

	
		homeMenuBar = new JMenuBar();
		settings = new JMenu("Settings");
		settings.addMenuListener(this);
		
		

	
		homeMenuBar.add(settings);

		setJMenuBar(homeMenuBar);


	
		midPanel = new JPanel(new GridLayout(5,1));

		KodeLbl = new JLabel(Kode);
		NamaLbl = new JLabel(Nama);
		HargaLbl = new JLabel(Harga);
		StokLbl = new JLabel(String.valueOf(Stok));
		
		
		midPanel.add(KodeLbl);
		midPanel.add(NamaLbl);
		midPanel.add(HargaLbl);
		midPanel.add(StokLbl);
	


		/*Table*/
		userTableP = new JPanel();
		

		Vector<Object> column = new Vector<>();
		column.add("Kode");
		column.add("Nama");
		column.add("Harga");
		column.add("Stok");
		
	
	
		Vector<Vector<Object>> row = new Vector<Vector<Object>>();
		for(User x : user) {
			Vector<Object> curr = new Vector<>();
			curr.add(x.getKode());    
			curr.add(x.getNama());    
			curr.add(x.getHarga());    
			curr.add(x.getStok());    
			
			
			row.add(curr);
		}
		
		userTable = new JTable(row, column);
		userTable.addMouseListener(this);
		tableScrollPane = new JScrollPane(userTable);
		tableScrollPane.setPreferredSize(new Dimension(350, 300));
		userTableP.add(tableScrollPane);

		/*Add to Frame*/
		add(midPanel, BorderLayout.NORTH);
		add(userTableP, BorderLayout.CENTER);

		setup();
	}

	void setup() {
		setVisible(true);
		setSize(400, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Home");
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == userTable) {
			int row = userTable.getSelectedRow();

			KodeLbl.setText(String.valueOf(userTable.getValueAt(row, 0)));
			NamaLbl.setText(String.valueOf(userTable.getValueAt(row, 1)));
			HargaLbl.setText(String.valueOf(userTable.getValueAt(row, 2)));
			StokLbl.setText(String.valueOf(userTable.getValueAt(row, 3)));
			
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {        
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void menuSelected(MenuEvent e) {
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
	}

	@Override
	public void menuCanceled(MenuEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}