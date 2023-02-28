// Java program to implement 
// a Simple Registration Form 
// using Java Swing 
  
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

class LoginAdmin extends JFrame implements ActionListener { 
    // Components of the Form 
    private Container c; 
    private JLabel title;
    private JLabel userLabel; 
    private JLabel passwordLabel;
    private JTextField userTextField; 
    private JPasswordField passwordField;
    private JButton loginButton; 
    private JButton resetButton;
    private JCheckBox showPassword;
  
    // constructor, to initialize the components 
    // with default values. 
    public LoginAdmin() 
    { 
        setTitle("Login");
        setBounds(10, 10, 370, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Login Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setForeground(new java.awt.Color(255, 51, 51));
        title.setBounds(90, 50, 200, 35); 
        c.add(title);
        
  
        userLabel = new JLabel("Username"); 
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        userLabel.setBounds(50, 150, 100, 30);
        c.add(userLabel); 
  
        userTextField = new JTextField(); 
        userTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        userTextField.setBackground(new java.awt.Color(255, 204, 204));
        userTextField.setBounds(150, 150, 150, 30);
        c.add(userTextField); 
  
        passwordLabel = new JLabel("Password"); 
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        passwordLabel.setBounds(50, 220, 100, 30);
        c.add(passwordLabel); 
  
        passwordField = new JPasswordField(); 
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        passwordField.setBackground(new java.awt.Color(255, 204, 204));
        passwordField.setBounds(150, 220, 150, 30);
        c.add(passwordField); 
        
        showPassword = new JCheckBox("show password");
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        showPassword.setBounds(150, 250, 150, 30);
        showPassword.addActionListener(this);
        c.add(showPassword);
      
        loginButton = new JButton("LOGIN"); 
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15)); 
        loginButton.setBounds(50, 300, 100, 30);
        loginButton.addActionListener(this); 
        c.add(loginButton); 
  
        resetButton = new JButton("RESET"); 
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resetButton.setBounds(200, 300, 100, 30); 
        resetButton.addActionListener(this); 
        c.add(resetButton); 
        
        setVisible(true); 
    }
    
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
         //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("imazmim") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                JOptionPane.showMessageDialog(this, "System will be upgraded soon ...");
                SocksStock stock = new SocksStock();
		stock.setVisible(true);
		setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        
         //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
      
    } 

} 

