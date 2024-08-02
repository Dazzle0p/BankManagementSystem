import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField withdrawlAmount;
    JButton withdrawl, back;
    String pinNumber;

    Withdrawl(String pinNumber){
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
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(225,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
//-> Withdrawl TEXTFIELD
        withdrawlAmount = new JTextField();
        withdrawlAmount.setBounds(220,300,300,30);
        image.add(withdrawlAmount);
// -> Deposit Button
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(220,340,140,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        if(ae.getSource() == withdrawl){
            String depoAmount = withdrawlAmount.getText();
            Date date = new Date();
            if(depoAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Amount can't be null");
            } else {
                try{
                     connection con = new connection();
                     String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+depoAmount+"')";
                     con.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,"Amount Withdrawl Successfully");
                     setVisible(false);
                     new Transaction(pinNumber).setVisible(true);
                   } catch(Exception e){
                    System.out.println(e);
                   }
        }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);;
        }
    }
    public static void main(String [] args){
        new Withdrawl("");
    }
}
