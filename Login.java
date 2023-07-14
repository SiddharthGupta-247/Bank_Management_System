
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField; 
    Login(){
        setTitle("Automated Teller Machine");//used to set the title of the frame 
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//size the size of image 
        ImageIcon i3=new ImageIcon(i2);//cpnverting Image class to ImageIcon class
        JLabel label=new JLabel(i3);
        label.setBounds(120, 10, 100,100);//set the image layout in frame 
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");//label to create the head element 
        text.setFont(new Font("Osward",Font.BOLD,38));//function to set the size color and style of font 
        text.setBounds(250, 40, 400,40); //configure the location of text in frame 
        text.setForeground(Color.BLACK);
        add(text);
        
        JLabel cardno=new JLabel("CARD NO:");//label to create the card number  element 
        cardno.setFont(new Font("Railway",Font.BOLD,28));//function to set the size color and style of font 
        cardno.setBounds(120, 150, 150,30); //configure the location of text in frame 
        add(cardno);
        
        cardTextField=new JTextField();//textfield for card number 
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");//label to create the pin element 
        pin.setFont(new Font("Railway",Font.BOLD,28));//function to set the size color and style of font 
        pin.setBounds(120, 220, 250,30); //configure the location of text in frame 
        add(pin);
        
        pinTextField=new JPasswordField();//textfield for card number 
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.PINK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.pink);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.pink);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.CYAN);//used to color the background of the frame
        setSize(800,480);//set the size of frame 
        setVisible(true);//set the visibility of the frame 
        setLocation(350,200);//set the initial location of the frame 
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardnumber= '"+cardnumber+"' and pin= '"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
               
    }
    public static void main(String args[])
    {
        new Login();
    }
}
