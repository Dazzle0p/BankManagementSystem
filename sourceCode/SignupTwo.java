import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

        JComboBox religionBox, catagoryBox, incomeBox, educationBox, occupationBox;
        JTextField  panTextfield, aadharTextField;
        JRadioButton scYes, scNo, eYes, eNo;
        JButton next;
        String formNum;

    Border blackline = BorderFactory.createLineBorder(Color.WHITE);

    SignupTwo(String formNum){

        this.formNum = formNum;
        setTitle("New Account Applicaton Form");
        setLayout(null);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("bg2.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(1000, 560, Image.SCALE_AREA_AVERAGING);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel bg = new JLabel(ii3);
        bg.setBounds(0,0,800,480);
        add(bg);


        JLabel additionalDetails = new JLabel("  Page 02 : Additional Details ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBorder(blackline);
        additionalDetails.setForeground(Color.white);
        additionalDetails.setBounds(240,25,300,25);
        bg.add(additionalDetails);
//-> relegion
        JLabel religion = new JLabel("Relegion : ");
        religion.setFont(new Font("OSWAL",Font.BOLD,16));
        religion.setBounds(50,70,150,20);
        religion.setForeground(Color.white);
        bg.add(religion);

        String valReligion[] = {"Hindu","Muslim","Sikh","Chirstian","Others",};
        religionBox = new JComboBox<>(valReligion);
        religionBox.setFont(new Font("OSWAl",Font.BOLD,14));
        religionBox.setBackground(Color.WHITE);
        religionBox.setBounds(200,70,400,23);
        bg.add(religionBox);
//-> Catagory
        JLabel catagory = new JLabel("Catagory : ");
        catagory.setFont(new Font("OSWAL",Font.BOLD,16));
        catagory.setForeground(Color.WHITE);
        catagory.setBounds(50,105,200,20);
        bg.add(catagory);

        String valCatagory[] ={"General","OBC","BC","SC","ST","Others"};
        catagoryBox = new JComboBox<>(valCatagory);
        catagoryBox.setFont(new Font("OSWAl",Font.BOLD,14));
        catagoryBox.setBackground(Color.WHITE);
        catagoryBox.setBounds(200,105,400,23);
        bg.add(catagoryBox);
//-> INCOME
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("OSWAL",Font.BOLD,16));
        income.setForeground(Color.white);
        income.setBounds(50,140,200,20);
        bg.add(income);

        String valIncome[] = {"Null","Upto 1,50,000","Upto 2,50,000","Upto 5,50,000","More Than 5,50,000"};
        incomeBox = new JComboBox<>(valIncome);
        incomeBox.setBounds(200,140,400,20);
        incomeBox.setBackground(Color.white);
        bg.add(incomeBox);
//-> Education
        JLabel education = new JLabel("Educational Qualification :");
        education.setFont(new Font("OSWAL",Font.BOLD,16));
        education.setForeground(Color.white);
        education.setBounds(50,173,200,20);
        bg.add(education);

        String valEducation[] = {"Non-Graduate","Under-Graduate","Post-Gradute","Others"};
        educationBox = new JComboBox<>(valEducation);
        educationBox.setBounds(260,175,340,20);
        educationBox.setBackground(Color.white);
        bg.add(educationBox);

//-> Occupation
        JLabel occupaton = new JLabel("Occupation : ");
        occupaton.setFont(new Font("OSWAL",Font.BOLD,16));
        occupaton.setBounds(50,203,200,20);
        occupaton.setForeground(Color.white);
        bg.add(occupaton);

        String valOccupation[] ={"Government", "Private","Student","Self Emloyed","Others"};
        occupationBox = new JComboBox<>(valOccupation);
        occupationBox.setBounds(200,203,400,20);
        occupationBox.setBackground(Color.WHITE);
        bg.add(occupationBox);

//-> Pan Number
        JLabel panNum = new JLabel("Pan No : ");
        panNum.setFont(new Font("OSWAL",Font.BOLD,16));
        panNum.setForeground(Color.white);
        panNum.setBounds(50,240,200,20);
        bg.add(panNum);

        panTextfield = new JTextField();
        panTextfield.setFont(new Font("OSWAl",Font.BOLD,16));
        panTextfield.setBounds(200,240,400,23);
        bg.add(panTextfield);
//-> AADHAR
        JLabel aadhar = new JLabel("Aadhar No : ");
        aadhar.setFont(new Font("OSWAL",Font.BOLD,16));
        aadhar.setForeground(Color.WHITE);
        aadhar.setBounds(50,275,200,20);
        bg.add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("OSWAl",Font.BOLD,16));
        aadharTextField.setBounds(200,275,400,23);
        bg.add(aadharTextField);
//-> SENIOR CITIZEN
        JLabel siniorCitizen = new JLabel("Senior Citizen : ");
        siniorCitizen.setFont(new Font("OSWAL",Font.BOLD,16));
        siniorCitizen.setForeground(Color.white);
        siniorCitizen.setBounds(50,310,200,20);
        bg.add(siniorCitizen);

        scYes = new JRadioButton("Yes");
        scYes.setBounds(220,310,180,20);
        scYes.setBackground(Color.WHITE);
        bg.add(scYes);

        scNo = new JRadioButton("No");
        scNo.setBounds(420,310,180,20);
        scNo.setBackground(Color.WHITE);
        bg.add(scNo);

        ButtonGroup citizonGroup = new ButtonGroup();
        citizonGroup.add(scYes);
        citizonGroup.add(scNo);
//-> EXISTING ACCOUNT      
        JLabel existingAccount = new JLabel("Existing Account : ");
        existingAccount.setFont(new Font("OSWAL",Font.BOLD,16));
        existingAccount.setForeground(Color.WHITE);
        existingAccount.setBounds(50,340,200,20);
        bg.add(existingAccount);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(220,340,180,20);
        eYes.setBackground(Color.WHITE);
        bg.add(eYes);

        eNo = new JRadioButton("No");
        eNo.setBounds(420,340,180,20);
        eNo.setBackground(Color.WHITE);
        bg.add(eNo);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eYes);
        existingAccountGroup.add(eNo);
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
        setVisible(true);
        setLocation(350,200);
//-> Changing Background Color of plane 
        getContentPane().setBackground(Color.WHITE);
}
        public void actionPerformed(ActionEvent ae)
        {
                
                String religion = (String) religionBox.getSelectedItem(); //Typecasting To String
                String catagory = (String) catagoryBox.getSelectedItem();
                String income = (String) incomeBox.getSelectedItem();
                String education = (String) educationBox.getSelectedItem();
                String occupaton = (String) occupationBox.getSelectedItem();

                String panNum = panTextfield.getText();
                String aadhar = aadharTextField.getText();

                String siniorCitizen = "";

                if(scYes.isSelected()){
                        siniorCitizen = "Yes";
                } else if (scNo.isSelected()){
                        siniorCitizen = "No";
                }
                String  existingAccount = "";
                
                if(eYes.isSelected()){
                        existingAccount = "YES";
                } else if (eNo.isSelected()){
                        existingAccount = "NO";
                }

                try{
                        if(aadhar.equals("")){
                                JOptionPane.showMessageDialog(null,"AADHAR can't be empty");
                        } else {
                                //-> Object of connection class
                                connection c = new connection();
                                //Insert intoTable using MySql query
                                String query = "insert into signupTwo values('"+formNum+"', '"+religion+"', '"+catagory+"', '"+income+"', '"+education+"', '"+occupaton+"', '"+panNum+"', '"+aadhar+"', '"+siniorCitizen+"', '"+existingAccount+"')";
                                //-> Passing query using DML COMMAND 
                                c.s.executeUpdate(query);

                                // object of SignUpThree
                                setVisible(false);
                                new SignupThree(formNum).setVisible(true);
                        }
                } catch (Exception e){
                        System.out.println(e);
                }
        }
        public static void main (String [] args)
        {
            new SignupTwo("");
        }
}