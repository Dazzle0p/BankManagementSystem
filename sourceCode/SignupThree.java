import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;
 
public class SignupThree extends JFrame implements ActionListener{

    JRadioButton savingAccountBut, currentAccountBut, fixDepoAccountBut, reccuringAccountBut;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submitBut, cancleBut;
    Border blackline = BorderFactory.createLineBorder(Color.black);
    String formNum;

    SignupThree(String formNum){
        this.formNum = formNum;

        setLayout(null);
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("bg1.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(1000, 560, Image.SCALE_AREA_AVERAGING);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel bg = new JLabel(ii3);
        bg.setBounds(0,0,800,480);
        add(bg);

//-> ACCOUNT DETAILS
        JLabel accountDetails = new JLabel("Page 03 : Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,20));
        accountDetails.setBounds(240,25,300,25);
        accountDetails.setForeground(Color.white);
        accountDetails.setBorder(blackline);
        bg.add(accountDetails);
//-> ACCOUNT TYPE
        JLabel selectAccountType = new JLabel("Select Account Type");
        selectAccountType.setFont(new Font("Raleway",Font.BOLD,25));
        selectAccountType.setForeground(Color.white);
        selectAccountType.setBounds(50,65,250,25);
        bg.add(selectAccountType);
//-> SAVING ACCOUNT BUTTON
        savingAccountBut = new JRadioButton("Saving");
        savingAccountBut.setFont(new Font("raleway",Font.BOLD,17));
        savingAccountBut.setBounds(50,100,150,25);
        savingAccountBut.setBackground(Color.WHITE);
        bg.add(savingAccountBut);
//-> CURRENT ACCOUNT
        currentAccountBut = new JRadioButton("Current");
        currentAccountBut.setFont(new Font("raleway",Font.BOLD,17));
        currentAccountBut.setBounds(210,100,150,25);
        currentAccountBut.setBackground(Color.WHITE);
        bg.add(currentAccountBut);
//-> FIX DEPOSITE ACCOUNT
        fixDepoAccountBut = new JRadioButton("Fix Deposite");
        fixDepoAccountBut.setFont(new Font("raleway",Font.BOLD,17));
        fixDepoAccountBut.setBounds(370,100,160,25);
        fixDepoAccountBut.setBackground(Color.WHITE);
        bg.add(fixDepoAccountBut);
//-> RECCURING DEPOSITE ACCOUNT
        reccuringAccountBut = new JRadioButton("Reccuring Deposite");
        reccuringAccountBut.setFont(new Font("raleway",Font.BOLD,17));
        reccuringAccountBut.setBounds(543,100,200,25);
        reccuringAccountBut.setBackground(Color.WHITE);
        bg.add(reccuringAccountBut);
//-> BUTTON GROUP
        ButtonGroup groupselectAccountTypeBut = new ButtonGroup();
        groupselectAccountTypeBut.add(savingAccountBut);
        groupselectAccountTypeBut.add(currentAccountBut);
        groupselectAccountTypeBut.add(fixDepoAccountBut);
        groupselectAccountTypeBut.add(reccuringAccountBut);

        JLabel cardNo = new JLabel("Service Required");
        cardNo.setFont(new Font("Raleway",Font.BOLD,25));
        cardNo.setBounds(50,140,300,25);
        cardNo.setForeground(Color.white);
        bg.add(cardNo);
// CheckBOXES ATM
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,17));
        c1.setBounds(50,180,200,25);
        c1.setForeground(Color.BLACK);
        c1.setBorder(blackline);
        bg.add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,17));
        c2.setBounds(300,180,200,25);
        c2.setForeground(Color.BLACK);
        c2.setBorder(blackline);
        bg.add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,17));
        c3.setBounds(540,180,200,25);
        c3.setForeground(Color.BLACK);
        c3.setBorder(blackline);
        bg.add(c3);

        c4 = new JCheckBox("Email & SMS alert");
        c4.setFont(new Font("Raleway",Font.BOLD,17));
        c4.setBounds(50,210,200,25);
        c4.setForeground(Color.BLACK);
        c4.setBorder(blackline);
        bg.add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,17));
        c5.setBounds(300,210,200,25);
        c5.setForeground(Color.BLACK);
        c5.setBorder(blackline);
        bg.add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,17));
        c6.setBounds(540,210,200,25);
        c6.setForeground(Color.BLACK);
        c6.setBorder(blackline);
        bg.add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,15));
        c7.setBounds(50,300,700,25);
        c7.setForeground(Color.WHITE);
        c7.setOpaque(false);
        c7.setBackground(new Color(0, 0, 0, 0));
        c7.setBorder(blackline);
        bg.add(c7);

        submitBut = new JButton("Submit");
        submitBut.setBackground(Color.BLACK);
        submitBut.setForeground(Color.WHITE);
        submitBut.setFont(new Font("Raleway", Font.BOLD,20));
        submitBut.setBounds(610,380,100,30);
        submitBut.addActionListener(this);
        bg.add(submitBut);

        cancleBut = new JButton("Cancle");
        cancleBut.setBackground(Color.BLACK);
        cancleBut.setForeground(Color.WHITE);
        cancleBut.setFont(new Font("Raleway", Font.BOLD,20));
        cancleBut.setBounds(500,380,100,30);
        cancleBut.addActionListener(this);
        bg.add(cancleBut);

        setSize(800,480);
        setBackground(Color.white);
        setLocation(350,200);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        // JRadioButton savingAccountBut, currentAccountBut, fixDepoAccountBut, reccuringAccountBut;
        if(ae.getSource() == submitBut){
            String accountType = null;
            if(savingAccountBut.isSelected()){
                accountType = "Saving Account";
            } else if(currentAccountBut.isSelected()){
                accountType = "Current Account";
            } else if(fixDepoAccountBut.isSelected()){
                accountType = "Fixed Deposite Account";
            } else if(reccuringAccountBut.isSelected()){
                accountType = "Reccurring Account";
            }

            Random random = new Random();
            String cardnumber = ""  + Math.abs((random.nextLong() % 90000000L) + 151_515_00_000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility +"ATM Card";
            } else if (c2.isSelected()){
                facility = facility +"Internet Banking";
            } else if (c3.isSelected()){
                facility = facility +"Mobile Banking";
            } else if (c4.isSelected()){
                facility = facility +"Email & SMS alert";
            } else if (c5.isSelected()){
                facility = facility +"Cheque Book";
            } else if(c6.isSelected()){
                facility = facility +"E-Statement";
            }
            
            try {
                 if(accountType.equals("")){
                     JOptionPane.showMessageDialog(null,"Please select Account Type");
                 } else {
                     //-> Object of connection class
                     connection c = new connection();
                     //Insert intoTable using MySql query
                     String query1 = "insert into signupThree values('"+formNum+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                     String query2 = "insert into login values('"+formNum+"','"+cardnumber+"', '"+pinnumber+"')";
                     //-> Passing query using DML COMMAND 
                     c.s.executeUpdate(query1);
                     c.s.executeUpdate(query2);

                     JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber+" \n Pin Number : "+pinnumber);
                     JOptionPane.showMessageDialog(null, "Deposie amount");
                     setVisible(false);
                     new Deposit(pinnumber).setVisible(true);
                 }   
            } catch(Exception e) {
                System.out.println(e);
            }
        } else if(ae.getSource() == cancleBut){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String [] args){
        new SignupThree("");
    }
}
