
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Transaction extends JFrame implements ActionListener {

    JButton deposite, withdrawl, fastCash, statement, pinchange, balanceEnquiry, exit;
    String pinNumber;
    Transaction(String pinNumber){

        this.pinNumber = pinNumber;
// -> Importing ATM image
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,680);
        add(image);
// -> Welcome message
        JLabel text = new JLabel("Select option from menu");
        text.setBounds(220,260,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,25));
        image.add(text);
// -> Deposit Button
        deposite = new JButton("Deposit Amount");
        deposite.setBounds(180,340,140,25);
        deposite.addActionListener(this);
        image.add(deposite);
// -> Withdraw Button
        withdrawl = new JButton("Withdraw Amount");
        withdrawl.setBounds(430,340,140,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
// -> Fast Cash
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(180,368,140,25);
        fastCash.addActionListener(this);
        image.add(fastCash);
// -> Mini Statement
        statement = new JButton("Mini Statement");
        statement.setBounds(430,370,140,25);
        statement.addActionListener(this);
        image.add(statement);
//-> PIN CHANGE
        pinchange = new JButton("Change Pin");
        pinchange.setBounds(180,397,140,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
//-> BALANCE ENQUIRY
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(430,397,140,25);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
//-> EXIT BUTTON
        exit = new JButton("Exit");
        exit.setBounds(180,425,390,25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(1000,680);
        setLocation(250,110);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
                System.exit(0);
        } else if (ae.getSource() == deposite) {
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdrawl){
                setVisible(false);
                new Withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
                setVisible(false);
                new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinchange){
                setVisible(false);
                new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry){
                setVisible(false);
                new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == statement){
                // setVisible(false);
                new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Transaction(" ");
    }
}