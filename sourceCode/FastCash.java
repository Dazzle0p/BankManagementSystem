import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, back, b8;
    JTextField t1;
    String pinNumber;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,680);
        add(image);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(230,260,700,35);
        image.add(l1);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(180,340,140,25);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(180,368,140,25);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(430,340,140,25);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(430,370,140,25);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(180,397,140,25);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(430,397,140,25);
        b6.addActionListener(this);
        image.add(b6);

        back = new JButton("BACK");
        back.setBounds(180,425,390,25);
        back.addActionListener(this);
        image.add(back);
        

        setSize(1000,680);
        setLocation(250,110);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs 500
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_Num = '"+pinNumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back) {
                this.setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            } else {
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}