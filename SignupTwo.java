
package bank.management.system;
import javax.swing.*;
import java.awt.*;


import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    
    
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JTextField pan,aadhar;
    JComboBox religion,income,category,occupation,education;
    String formno;
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM  PAGE 2");
  
        
        JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String varReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(varReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
       
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String varCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(varCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String varIncome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income=new JComboBox(varIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
      
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[]={"Non Graduate","Graduate","Post Graduate","Doctrate","Other"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
        
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[]={"Salaried","Self Employed","Business","Student","Other"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        
               
        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel City=new JLabel("Adhaar Number:");
        City.setFont(new Font("Railway",Font.BOLD,20));
        City.setBounds(100,490,200,30);
        add(City);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Railway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.cyan);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.cyan);
        add(sno);
       
        ButtonGroup citizenGroup=new ButtonGroup();
        citizenGroup.add(syes);
        citizenGroup.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.cyan);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.cyan);
        add(eno);
       
        ButtonGroup eGroup=new ButtonGroup();
        eGroup.add(eyes);
        eGroup.add(eno);
        
        next=new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.pink);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.CYAN);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorCitizen=null;
        
        if(syes.isSelected())
        {
            seniorCitizen="Yes";
        }
        else if(sno.isSelected())
        {
            seniorCitizen="No";
        }
      
        String existingaccount=null;
        if(eyes.isSelected())
        {
            existingaccount="Yes";
        }
        else if(sno.isSelected())
        {
            existingaccount="No";
        }
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
      
        
        try{
            
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                //signupThree
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
  public static void main(String args[])
  {
      new SignupTwo("");
  }
  
}
