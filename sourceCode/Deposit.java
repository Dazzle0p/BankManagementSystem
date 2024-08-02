import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField depositAmount;
    JButton deposit, back;
    String pinNumber;

    Deposit(String pinNumber){
        setLayout(null);
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
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(230,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
//-> DEPOSIT TEXTFIELD
        depositAmount = new JTextField();
        depositAmount.setBounds(220,300,300,30);
        image.add(depositAmount);
// -> Deposit Button
        deposit = new JButton("Deposit");
        deposit.setBounds(220,340,140,25);
        deposit.addActionListener(this);
        image.add(deposit);

// -> Back Button
        back = new JButton("Back");
        back.setBounds(380,340,140,25);
        back.addActionListener(this);
        image.add(back);

        setSize(1000,680);
        setLocation(250,110);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String depoAmount = depositAmount.getText();
            Date date = new Date();
            try {   
                if(depoAmount.equals(" ")){
                JOptionPane.showMessageDialog(null,"Amount can't be null");
                } else {
                     connection con = new connection();
                     String query = "insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+depoAmount+"')";
                     con.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,""+depoAmount+" Rupees deposited Successfully");
                     setVisible(false);
                     new Transaction(pinNumber).setVisible(true);
                }
            } catch(Exception e){
                System.out.println(e);
               }
        
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);     
        }
    }
    public static void main(String [] args){
        new Deposit("");
    }
}
