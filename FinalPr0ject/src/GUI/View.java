package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.Vector;
import java.awt.*;

public class View extends JFrame implements ActionListener {

    Vector<User> user;
    
    JLabel ViewLbl;
    JTextField KodeField,NamaField,HargaField,StokField;
  
    JButton ViewBtn, InsertBtn;
    JPanel midPanel, topPanel, botPanel,
            KodeLblP,NamaLblP, HargaLblP,StokLblP,
            KodeFieldP,NamaFieldP, HargaFieldP,StokFieldP;


    public View(Vector<User> user) {

        this.user = user;
        
        Dimension dimensionSize = new Dimension(120, 30);

    
        topPanel = new JPanel();
        ViewLbl = new JLabel("View Form");
        topPanel.add(ViewLbl);
        topPanel.setBorder(new EmptyBorder(30, 0, 50, 0));

    
        midPanel = new JPanel(new GridLayout(2,2));

      
        KodeLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        KodeLblP.setBorder(new EmptyBorder(0, 60, 0, 0));
        KodeFieldP = new JPanel();
        
        NamaLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        NamaLblP.setBorder(new EmptyBorder(0, 60, 0, 0));
        NamaFieldP = new JPanel();
        
        HargaLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        HargaLblP.setBorder(new EmptyBorder(0, 60, 0, 0));
        HargaFieldP = new JPanel();

        StokLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        StokLblP.setBorder(new EmptyBorder(0, 60, 0, 0));
        StokFieldP = new JPanel();

     


     
        midPanel.add(KodeLblP);
        midPanel.add(KodeFieldP);
        midPanel.add(NamaLblP);
        midPanel.add(NamaFieldP);
        midPanel.add(HargaLblP);
        midPanel.add(HargaFieldP);
        midPanel.add(StokLblP);
        midPanel.add(StokFieldP);
       

    
        
        botPanel = new JPanel();

        ViewBtn = new JButton("View");
        ViewBtn.setPreferredSize(new Dimension(90, 30));
        InsertBtn = new JButton("Insert");
        InsertBtn.setPreferredSize(new Dimension(90, 30));

        ViewBtn.addActionListener(this);
        InsertBtn.addActionListener(this);

        botPanel.add(ViewBtn);
        botPanel.add(InsertBtn);
        botPanel.setBorder(new EmptyBorder(30, 0, 50, 0));
        
        
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.SOUTH);
        
        setup();
    }

    void setup() {
        setVisible(true);
        setSize(350, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("View Form");
    }
}