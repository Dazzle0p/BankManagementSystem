import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

        long random;
        JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
        JButton next;
        JRadioButton male, female, married, unmarried;
        JDateChooser datechooser;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    SignupOne(){
        setTitle("New Account Applicaton Form");
        setLayout(null);
        
//-> Generarion Randon Application Number using RandomFunction
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 100L); // Craeting Four DigitRandom Number
                                                                  // Math.abs used to make number +

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("bg1.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(1000, 560, Image.SCALE_AREA_AVERAGING);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel bg = new JLabel(ii3);
        bg.setBounds(0,0,800,480);
        add(bg);

        JLabel formNum = new JLabel("Application NO : " + random);
        formNum.setFont(new Font("Raleway",Font.BOLD,20));
        formNum.setBounds(275/*From Left*/,0/*length from Top */,300/*Text legth */,25/*height */);
        formNum.setForeground(Color.white);
        bg.add(formNum);
        
        JLabel PersonDetails = new JLabel("  Page 01 : Personal Details ");
        PersonDetails.setFont(new Font("Raleway",Font.BOLD,20));
        PersonDetails.setForeground(Color.WHITE);
        PersonDetails.setBorder(blackline);
        PersonDetails.setBounds(240,25,275,25);
        bg.add(PersonDetails);
//-> NAME
        JLabel Name = new JLabel("Name : ");
        Name.setFont(new Font("OSWAL",Font.BOLD,16));
        Name.setForeground(Color.WHITE);
        Name.setBounds(50,70,150,20);
        bg.add(Name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        nameTextField.setBounds(200,70,400,23);
        bg.add(nameTextField);
//-> FATHERS NAME
        JLabel fathersName = new JLabel("Father's Name : ");
        fathersName.setFont(new Font("OSWAL",Font.BOLD,16));
        fathersName.setForeground(Color.WHITE);
        fathersName.setBounds(50,100,200,20);
        bg.add(fathersName);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        fnameTextField.setBounds(200,100,400,23);
        bg.add(fnameTextField);
//-> DATE OF BERTH
        JLabel dob = new JLabel("D.O.B : ");
        dob.setFont(new Font("OSWAL",Font.BOLD,16));
        dob.setForeground(Color.WHITE);
        dob.setBounds(50,130,200,20);
        bg.add(dob);

        datechooser = new JDateChooser();
        datechooser.setBounds(200,130,400,20);
        bg.add(datechooser);
//-> GENDER
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("OSWAL",Font.BOLD,16));
        gender.setForeground(Color.WHITE);
        gender.setBounds(50,160,200,20);
        bg.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200,160,180,20);
        male.setBackground(Color.WHITE);
        bg.add(male);

        female = new JRadioButton("Female");
        female.setBounds(400,160,180,20);
        female.setBackground(Color.WHITE);
        bg.add(female);

//-> To Group male and female button To select  only one
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
//-> GMAIL
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("OSWAL",Font.BOLD,16));
        // email.setForeground(Color.WHITE);
        email.setBounds(50,190,200,20);
        bg.add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        emailTextField.setBounds(200,190,400,23);
        bg.add(emailTextField);
//-> MARITAL STATUS
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("OSWAL",Font.BOLD,16));
        marital.setForeground(Color.WHITE);
        marital.setBounds(50,220,200,20);
        bg.add(marital);

        married = new JRadioButton("Married");
        married.setBounds(200,220,180,20);
        married.setBackground(Color.WHITE);
        bg.add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,220,180,20);
        unmarried.setBackground(Color.WHITE);
        bg.add(unmarried);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
//-> ADDRESS
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("OSWAL",Font.BOLD,16));
        //address.setForeground(Color.WHITE);
        address.setBounds(50,250,200,20);
        bg.add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        addressTextField.setBounds(200,250,400,23);
        bg.add(addressTextField);
//-> CITY
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("OSWAL",Font.BOLD,16));
        city.setForeground(Color.WHITE);
        city.setBounds(50,280,200,20);
        bg.add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        cityTextField.setBounds(200,280,400,23);
        bg.add(cityTextField);
//-> STATE
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("OSWAL",Font.BOLD,16));
        state.setForeground(Color.WHITE);
        state.setBounds(50,310,200,20);
        bg.add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        stateTextField.setBounds(200,310,400,23);
        bg.add(stateTextField);
//-> PINCODE       
        JLabel pinCode = new JLabel("Pincode : ");
        pinCode.setFont(new Font("OSWAL",Font.BOLD,16));
        pinCode.setForeground(Color.WHITE);
        pinCode.setBounds(50,340,200,20);
        bg.add(pinCode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        pincodeTextField.setBounds(200,340,400,23);
        bg.add(pincodeTextField);
//-> NEXT
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,20));
        next.setBounds(500,380,100,30);
        next.addActionListener(this);
        bg.add(next);

//-> Creating Frame
        setSize(800,480);
        setLocation(350,200);
        setUndecorated(true);
        setVisible(true);
        
//-> Changing Background Color of plane 
        getContentPane().setBackground(Color.WHITE);
}
        public void actionPerformed(ActionEvent ae)
        {
                String formNum = "" + random;//Converting Long form number into String to store in database
                String name = nameTextField.getText();
                String fname = fnameTextField.getText();
                String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText(); 
                //Because Ui component return TextField So we have to concatenate
                String gender = null;
                if(male.isSelected()){
                        gender = "Male";
                } else if (female.isSelected()) {
                        gender = "Female";
                }
                String email = emailTextField.getText();
                String marital = null;
                if(married.isSelected()){
                        marital = "Unmarried";
                } else if (unmarried.isSelected()){
                        marital = "Married";
                }
                String address = addressTextField.getText();
                String city = cityTextField.getText();
                String State = stateTextField.getText();
                String pinCode = pincodeTextField.getText();

                try{
                        if(name.equals("")){
                                JOptionPane.showMessageDialog(null,"Name can't be empty");
                        } else {
                                //-> Object of connection class
                                connection c = new connection();
                                //Insert intoTable using MySql query
                                String query = "insert into signupOne values('"+formNum+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"','"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+State+"', '"+pinCode+"')";
                                //-> Passing query using DML COMMAND 
                                c.s.executeUpdate(query);

                                setVisible(false);
                                new SignupTwo(formNum).setVisible(true);
                        }
                } catch (Exception e){
                        System.out.println(e);
                }
        }
        public static void main (String [] args)
        {
            new SignupOne();
        }
}