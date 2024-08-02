import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;

// JFrame is a class of swing 
//For ActionListner interface WE have to import awt.event.*;

public class Login extends JFrame implements ActionListener{

    // Defining things Globaly So it can be accessed from AnyWere in Code
    JButton SignIn, SignUp, Clear;
    JTextField CardTextField;
    JPasswordField PinTextField;
    Login(){
        setTitle("BANKING MANAGEMENT SYSTEM");
        setLayout(null);
        //Changing Background Color
        getContentPane().setBackground(Color.WHITE);
        
        // Placing image to frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankingLOgo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(50,10,150,100);
        add(lable);

        // Placing image to frame 
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Backg.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(1000, 560, Image.SCALE_AREA_AVERAGING);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel bg = new JLabel(ii3);
        bg.setBounds(0,0,800,480);
        add(bg);


        //Welcome Message
        JLabel text = new JLabel("WELCOME TO APNA BANK");
        text.setFont(new Font("Osward", Font.BOLD, 33));
        text.setBounds(220/*From Left*/,40/*length from Top */,450/*Text legth */,40/*height */);
        text.setForeground(Color.WHITE);
        bg.add(text);

        JLabel textt = new JLabel(" -<>- Paishe pahochaye ghar ghar tak -<>- ");
        textt.setFont(new Font("Osward", Font.BOLD, 20));
        textt.setBounds(220/*From Left*/,80/*length from Top */,450/*Text legth */,30/*height */);
        textt.setForeground(Color.WHITE);
        bg.add(textt);

        //Card Number
        JLabel cardNum =new JLabel("Card No :");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNum.setBounds(80/*From Left*/,180/*length from Top */,150/*Text legth */,30/*height */);
        cardNum.setForeground(Color.WHITE);
        bg.add(cardNum);

        //TextField For user to enter cardnumber
        CardTextField = new JTextField();
        CardTextField.setBounds(235,182,400,30);
        bg.add(CardTextField);

        //Pin
        JLabel Pin =new JLabel("Pin         :");
        Pin.setFont(new Font("Raleway", Font.BOLD, 30));
        Pin.setBounds(80/*From Left*/,250/*length from Top */,150/*Text legth */,30/*height */);
        Pin.setForeground(Color.WHITE);
        bg.add(Pin);

        //TextField For user to enter Pin
        PinTextField = new JPasswordField();
        PinTextField.setBounds(235,252,400,30);
        bg.add(PinTextField);

        //Creating Buttons Using JButton class of Swing
        SignIn = new JButton("SIGN IN");
        SignIn.setBounds(255, 300,150,30);
        // To Catch event of Button (Click)
        SignIn.addActionListener(this);
        bg.add(SignIn);

        //Creating Buttons Using JButton class of Swing
        Clear = new JButton("CLEAR");
        Clear.setBounds(465,300,150,30);
        // To Catch event of Button (Click)
        Clear.addActionListener(this);
        bg.add(Clear);


        //Creating Buttons Using JButton class of Swing
        SignUp = new JButton("SIGN UP");
        SignUp.setBounds(357,350,150,30);
        // To Catch event of Button (Click)
        SignUp.addActionListener(this);
        bg.add(SignUp);

        setSize(800,480);
        setUndecorated(true);
        setVisible(true);
        setLocation(350,200);

    }
    // Overriden method of inerface ActionListener
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
            CardTextField.setText("");
            PinTextField.setText("");
        } else if (ae.getSource() == SignUp){
            setVisible(false);
            // Switching To SignUpForm
            new SignupOne().setVisible(true);
        } else if (ae.getSource() == SignIn){
            connection con = new connection();
            String cardNumber = CardTextField.getText();
            String pinNumber = PinTextField.getText();
            String query = "select * from login where Card_Num = '"+cardNumber+"' and Pin_Num = '"+pinNumber+"'";
            
            try{
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or PIN");
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        
    }

    public static void main(String [] args)
    {
        new Login();
    }
}