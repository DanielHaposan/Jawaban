package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Insert extends JFrame  implements ActionListener {

    Vector<User> user;

    JPanel topPanel, midPanel, botPanel;
    JLabel InsertLbl, KodeLbl, NamaLbl, HargaLbl, StokLbl;
    JTextField KodeText, NamaText, HargaText, StokText;
   
  

  
    JPanel KodeLblP, NamaLblP, HargaLblP, StokLblP,
    KodeTextP, NamaTextP,HargaTextP,StokTextP;
    JButton InsertBtn, ViewBtn;

    
    public Insert(Vector<User> user) {

        
        this.user = user;        

        Dimension box = new Dimension(130, 30);
        Color colorBG = Color.cyan;

    
        JPanel topPanel = new JPanel();
        JLabel InsertLbl = new JLabel("Insert Data");
        topPanel.setBorder(new EmptyBorder(10, 0, 30, 0));
        topPanel.add(InsertLbl);


        
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(5, 2));

        KodeLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        KodeLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        KodeTextP = new JPanel();
        
        KodeLbl = new JLabel("Kode");
        KodeText = new JTextField();
        KodeText.setPreferredSize(box);

        KodeLblP.add(KodeLbl);
        KodeTextP.add(KodeText);

        NamaLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        NamaLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        NamaTextP = new JPanel();
        
        NamaLbl = new JLabel("Nama");
        NamaText = new JTextField();
        NamaText.setPreferredSize(box);

        NamaLblP.add(NamaLbl);
        NamaTextP.add(NamaText);
        
        HargaLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        HargaLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        NamaTextP = new JPanel();
        
        HargaLbl = new JLabel("Harga");
        HargaText = new JTextField();
        HargaText.setPreferredSize(box);

        HargaLblP.add(HargaLbl);
        HargaTextP.add(HargaText);
        
       

        StokLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        StokLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        StokTextP = new JPanel();
       
        StokLbl = new JLabel("Stok");
        StokText = new JTextField();
        StokText.setPreferredSize(box);

        StokLblP.add(StokLbl);
        StokTextP.add(StokText);

        midPanel.add(KodeLblP);
        midPanel.add(KodeTextP);
        midPanel.add(NamaLblP);
        midPanel.add(NamaTextP);
        midPanel.add(HargaLblP);
        midPanel.add(StokLblP);
      

        botPanel = new JPanel();

        ViewBtn = new JButton("View");
        ViewBtn.addActionListener(this);
        
        ViewBtn.setPreferredSize(new Dimension(90, 30));
        InsertBtn = new JButton("Insertter");
        InsertBtn.setPreferredSize(new Dimension(90, 30));

        InsertBtn.addActionListener(this);

        botPanel.add(ViewBtn);
        botPanel.add(InsertBtn);

        
        topPanel.setBackground(colorBG);
        midPanel.setBackground(colorBG);
        botPanel.setBackground(colorBG);
        KodeLblP.setBackground(colorBG);
        NamaLblP.setBackground(colorBG);
        HargaLblP.setBackground(colorBG);
        StokLblP.setBackground(colorBG);
       
        KodeTextP.setBackground(colorBG);
        NamaTextP.setBackground(colorBG);
       
        InsertBtn.setBackground(Color.WHITE);
    
        /*Add all panel */
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.SOUTH);

        setup();
    }

    void setup() {
        setVisible(true);
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Insert Data");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == InsertBtn) {
            
            //get current data
            String Kode = KodeText.getText();
            String Nama = NamaText.getText();
            String Harga = HargaText.getText();
            String Stok = StokText.getText();
         
            if(checkValidUser(Kode, Nama, Harga,Stok)) {
             
               
                user.add(new User(Kode, Nama, Harga,Stok));

                this.dispose();
                new Home(user, Kode);
            }
        }
        else if(e.getSource() == ViewBtn) {
            this.dispose();

            new View(user);
        }
    }

    boolean checkValidUser(String Kode, String Nama, String Harga, String Stok) {
        if(Kode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kode must be filled!", "Insertter Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(Nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama must be filled!", "Insertter Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(Harga.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga must be filled!", "Insertter Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(Stok.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Stok can't be 0!", "Insertter Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        return true;
    }

}
