import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField newPinPasswordfield,reEnterPinPaswordfield;
    JButton changeBut,backBut;                               
    JLabel l1,l2,l3;
    String Pin_Num;
    PinChange(String Pin_Num){
        this.Pin_Num = Pin_Num;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,680);
        add(image);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(290,260,700,35);
        image.add(l1);
        
        l2 = new JLabel("Enter New Pin:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(210,315,150,35);
        image.add(l2);
        
        l3 = new JLabel("Re-Enter New Pin:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(210,345,200,35);
        image.add(l3);
        
        newPinPasswordfield = new JPasswordField();
        newPinPasswordfield.setFont(new Font("Raleway", Font.BOLD, 25));
        newPinPasswordfield.setBounds(360,320,180,25);
        image.add(newPinPasswordfield);
        
        reEnterPinPaswordfield = new JPasswordField();
        reEnterPinPaswordfield.setFont(new Font("Raleway", Font.BOLD, 25));
        reEnterPinPaswordfield.setBounds(360,348,180,25);
        image.add(reEnterPinPaswordfield);
        
        changeBut = new JButton("CHANGE");
        changeBut.addActionListener(this);
        changeBut.setBounds(180,395,390,25);
        image.add(changeBut);


        backBut = new JButton("BACK");
        backBut.addActionListener(this);
        backBut.setBounds(180,425,390,25);
        image.add(backBut);
        
        setSize(1000,680);
        setLocation(250,110);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){        
            String newPin_Num = newPinPasswordfield.getText();
            String reEnterNewPin_Num = reEnterPinPaswordfield.getText();
            
            if(!newPin_Num.equals(reEnterNewPin_Num)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                return;
            }
            
            if(ae.getSource()==changeBut){
                if (newPinPasswordfield.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New Pin");
                }
                else if (reEnterPinPaswordfield.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new Pin");
                } else {
            try{
// Updating Pin in all Tables 
                connection con = new connection();
                String q1 = "update bank set Pin_Num = '"+reEnterNewPin_Num+"' where Pin_Num = '"+Pin_Num+"' ";
                String q2 = "update login set Pin_Num = '"+reEnterNewPin_Num+"' where Pin_Num = '"+Pin_Num+"' ";
                String q3 = "update signupThree set Pin_Num = '"+reEnterNewPin_Num+"' where Pin_Num = '"+Pin_Num+"' ";

                con.s.executeUpdate(q1);
                con.s.executeUpdate(q2);
                con.s.executeUpdate(q3);

                System.out.println("Database updates successful");
                JOptionPane.showMessageDialog(null, "Pin Number changed successfully");
                setVisible(false);
                new Transaction(newPin_Num).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                }
            }else if(ae.getSource()==backBut){
                setVisible(false);
                new Transaction(Pin_Num).setVisible(true);   
            }
        
    }

    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}