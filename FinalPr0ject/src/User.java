

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
	JLabel nameLbl, addressLbl, genderLbl, ageLbl, passwordLbl;
	JButton backBtn;
	JMenuBar homeMenuBar;
	JMenu settings;
	JMenuItem logout;
	JTable userTable;
	JScrollPane tableScrollPane;

	public Home(Vector<User> user, String loginName) {

		/*populate the vector user*/
		this.user = user;

		/*get current user*/
		int index = -1;
		
		for(int x=0;x<user.size();x++) {
			if(user.get(x).getName().equals(loginName)) {
				index = x;
				break;
			}
		}

		String name = user.get(index).getName();
		String address = user.get(index).getAddress();
		String gender = user.get(index).getGender();
		int age = user.get(index).getAge();
		String password = user.get(index).getPassword();

		/*JMenuBar*/
		homeMenuBar = new JMenuBar();
		settings = new JMenu("Settings");
		settings.addMenuListener(this);
		logout = new JMenuItem("Logout");
		logout.addActionListener(this);

		settings.add(logout);
		homeMenuBar.add(settings);

		setJMenuBar(homeMenuBar);


		/*MidPanel*/
		midPanel = new JPanel(new GridLayout(5,1));

		nameLbl = new JLabel(name);
		addressLbl = new JLabel(address);
		genderLbl = new JLabel(gender);
		ageLbl = new JLabel(String.valueOf(age));
		passwordLbl = new JLabel(password);
		
		midPanel.add(nameLbl);
		midPanel.add(addressLbl);
		midPanel.add(genderLbl);
		midPanel.add(ageLbl);
		midPanel.add(passwordLbl);


		/*Table*/
		userTableP = new JPanel();
		
		//take column
		Vector<Object> column = new Vector<>();
		column.add("Name");
		column.add("Address");
		column.add("Gender");
		column.add("Age");
		column.add("Password");
	
		//take row
		Vector<Vector<Object>> row = new Vector<Vector<Object>>();
		for(User x : user) {
			Vector<Object> curr = new Vector<>();
			curr.add(x.getName());    
			curr.add(x.getAddress());    
			curr.add(x.getGender());    
			curr.add(x.getAge());    
			curr.add(x.getPassword());
			
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout) {
			this.dispose();
			new Login(user);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == userTable) {
			int row = userTable.getSelectedRow();

			nameLbl.setText(String.valueOf(userTable.getValueAt(row, 0)));
			addressLbl.setText(String.valueOf(userTable.getValueAt(row, 1)));
			genderLbl.setText(String.valueOf(userTable.getValueAt(row, 2)));
			ageLbl.setText(String.valueOf(userTable.getValueAt(row, 3)));
			passwordLbl.setText(String.valueOf(userTable.getValueAt(row, 4)));
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
		System.out.println("test Selected");
	}

	@Override
	public void menuDeselected(MenuEvent e) {
	}

	@Override
	public void menuCanceled(MenuEvent e) {
	}

}