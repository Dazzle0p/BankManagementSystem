import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.Border;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton backBut, b2, b3;
    JLabel l1, l2, image;
    String pin;
    Border blackline = BorderFactory.createLineBorder(Color.black);

    BalanceEnquiry(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,680);
        add(image);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(220,260,700,75);
        image.add(l1);

        backBut = new JButton("BACK");
        backBut.setBackground(Color.GREEN);
        backBut.setForeground(Color.BLACK);
        backBut.setBorder(blackline);
        backBut.setFont(new Font("Dialog BOLD", Font.BOLD, 20));
        backBut.setBounds(180,380,390,25);
        image.add(backBut);
        int balance = 0;
        try{
            connection c1 = new connection();
            ResultSet rs = c1.s.executeQuery("select * from bank where Pin_Num = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        l1.setText("Your Current Account Balance is Rs "+"\n"+balance);

        backBut.addActionListener(this);

        setSize(1000,680);
        setLocation(250,110);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}