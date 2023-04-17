import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Aicode extends JFrame  //extend JFrame class into Aicode code
{
    private JTextField passwordField;
    private JButton validateButton;

    private static final ArrayList<String> COMMON_PASSWORDS = new ArrayList<String>() 
    {{
        add("123456");
        add("password");   //store valid password using ArrayList data structure
        add("123456789");
        add("12345678");
        add("12345");
    }};

    private static boolean checkPassword(String password) // creating method for checking password
    {
        Random random = new Random();   
        // creating object of Random class for generating random numbers from users
        int aiDecision = random.nextInt(10) + 1; //generating random numbers between 1 to 10 
        if (COMMON_PASSWORDS.contains(password)) 
        {
            return false;
        } 
        else if (password.length() < 6) 
        {
            return false;
        } 
        else if (aiDecision <= 8) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    private void validatePassword()  //creating method for action on button click
    {
        String password = passwordField.getText();
        boolean isSecure = checkPassword(password);
        if (isSecure) {
            JOptionPane.showMessageDialog(this, "Password accepted.", "Password Validation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "This password is not secure. Please choose a different one.", "Password Validation", JOptionPane.WARNING_MESSAGE);
        }
    }

    public Aicode()    //default constructor of the main class
    {
        setTitle("AI Cyber Security Solution");  // creating gui using swing module
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for closing window on click of close button
        //setLocationRelativeTo(null);

        JLabel passwordLabel = new JLabel("Enter a password:");  // creating label
        passwordField = new JTextField();
        passwordField.setColumns(20);
        validateButton = new JButton("Validate");   // creating button 
        validateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                validatePassword();
            }
        });

        JPanel panel = new JPanel();  //creating panel container for containing button,label,textfield
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(validateButton);
        add(panel);
    }

    public static void main(String[] args)   // main method of the Aicode class
    {
        Aicode validator = new Aicode();
        validator.setVisible(true);
    }
}