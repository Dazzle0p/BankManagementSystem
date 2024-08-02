import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton exitBut, b2;
    JLabel miniStateJlable;
    MiniStatement(String pinNumber){


        super("Mini Statement");
        getContentPane().setBackground(Color.BLACK);
         
        miniStateJlable = new JLabel();
        miniStateJlable.setBounds(15, 70, 400, 170);
        miniStateJlable.setForeground(Color.white);
        add(miniStateJlable);
        
        JLabel bankJLabel = new JLabel("Apna Bank");
        bankJLabel.setBounds(170,5,60,35);
        bankJLabel.setForeground(Color.white);
        add(bankJLabel);
        
        JLabel cardnumJlable = new JLabel();
        cardnumJlable.setBounds(20, 45, 300, 20);
        cardnumJlable.setForeground(Color.WHITE);
        add(cardnumJlable);
        
        JLabel balanceJLabel = new JLabel();
        balanceJLabel.setBounds(20, 65, 300, 20);
        balanceJLabel.setForeground(Color.white);
        add(balanceJLabel);

        setSize(410,220);
        setLocation(418,339);
        setUndecorated(true);
        
        try{
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from login where Pin_Num = '"+pinNumber+"'");
            while(rs.next()){
                cardnumJlable.setText("Card Number:    " + rs.getString("Card_Num").substring(0, 4) + "XXXXXXXX" + rs.getString("Card_Num").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            connection c1  = new connection();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where Pin_Num = '"+pinNumber+"'");
            while(rs.next()){
                // USING HTML TAG FOR SPACE
                miniStateJlable.setText(miniStateJlable.getText() + "<html>"+rs.getString("Date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><html>");
                if(rs.getString("Type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("Amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            balanceJLabel.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        exitBut = new JButton("Exit");
        add(exitBut);
        exitBut.addActionListener(this);      
        exitBut.setBounds(10,195,390,25);
        exitBut.setBackground(Color.GREEN);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}