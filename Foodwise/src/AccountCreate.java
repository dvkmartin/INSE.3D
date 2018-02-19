import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.util.*;
import java.sql.Wrapper;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class AccountCreate extends JFrame{

	private JFrame frmFoodwiseCreate;
	private JTextField txtEmailAddress;
	private JTextField txtReenterEmailAddress;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;


	/**
	 * Create the application.
	 */
	public AccountCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	static Properties properties = new Properties();
    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
    }
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";  
    static final String Database_Path = "jdbc:mysql://77.95.179.45:3306/new?verifyServerCertificate=false&useSSL=true";
    static final String DBUsername = "inse";
    static final String DBPassword = "inse3d";
    Wrapper connect = null;
    
	private void initialize() {
		frmFoodwiseCreate = new JFrame();
		frmFoodwiseCreate = this;
		frmFoodwiseCreate.setTitle("Foodwise");
		frmFoodwiseCreate.setBounds(100, 100, 400, 300);
		frmFoodwiseCreate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodwiseCreate.getContentPane().setLayout(null);
		frmFoodwiseCreate.setResizable(false);
		
		JLabel lblCreateAnAccount = DefaultComponentFactory.getInstance().createLabel("Create an Account");
		lblCreateAnAccount.setBounds(180, 25, 116, 14);
		frmFoodwiseCreate.getContentPane().add(lblCreateAnAccount);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setToolTipText("Username");
		txtEmailAddress.setBounds(148, 50, 175, 20);
		frmFoodwiseCreate.getContentPane().add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		txtReenterEmailAddress = new JTextField();
		txtReenterEmailAddress.setToolTipText("Re-enter Email Address");
		txtReenterEmailAddress.setColumns(10);
		txtReenterEmailAddress.setBounds(148, 81, 175, 20);
		frmFoodwiseCreate.getContentPane().add(txtReenterEmailAddress);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setBounds(148, 174, 131, 23);
		frmFoodwiseCreate.getContentPane().add(btnCreateAccount);
		
		JTextArea txtValidation = new JTextArea();
		txtValidation.setBounds(10, 238, 364, 22);
		frmFoodwiseCreate.getContentPane().add(txtValidation);
		
		JLabel lblUsername = DefaultComponentFactory.getInstance().createLabel("Email Address");
		lblUsername.setBounds(57, 53, 88, 14);
		frmFoodwiseCreate.getContentPane().add(lblUsername);
		
		JLabel lblPassword = DefaultComponentFactory.getInstance().createLabel("Password");
		lblPassword.setBounds(81, 115, 64, 14);
		frmFoodwiseCreate.getContentPane().add(lblPassword);
		
		JLabel lblReenterEmailAddress = DefaultComponentFactory.getInstance().createLabel("Re-enter Email Address");
		lblReenterEmailAddress.setBounds(10, 84, 147, 14);
		frmFoodwiseCreate.getContentPane().add(lblReenterEmailAddress);
		
		JLabel lblReenterPassword = DefaultComponentFactory.getInstance().createLabel("Re-enter Password");
		lblReenterPassword.setBounds(28, 146, 117, 14);
		frmFoodwiseCreate.getContentPane().add(lblReenterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 112, 175, 20);
		frmFoodwiseCreate.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(148, 143, 175, 20);
		frmFoodwiseCreate.getContentPane().add(passwordField_1);
		
		JTextArea txtrEmailValidationCheck = new JTextArea();
		txtrEmailValidationCheck.setText("Please enter your email address!");
		txtrEmailValidationCheck.setBounds(10, 208, 364, 22);
		frmFoodwiseCreate.getContentPane().add(txtrEmailValidationCheck);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFoodwiseCreate.setVisible(false);
				frmFoodwiseCreate.dispose();
				new Login().setVisible(true);
				
			}
		});
		returnBtn.setBounds(10, 11, 89, 23);
		getContentPane().add(returnBtn);
		
		
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String reciever = txtEmailAddress.getText();
				{
				if(passwordField.getText().equals("") || (passwordField_1.getText().equals(""))) {
					txtValidation.setText("Please enter your password!");
						}
				if(txtEmailAddress.getText().equals("") || (txtReenterEmailAddress.getText().equals(""))) {
					txtrEmailValidationCheck.setText("Please enter your email address!");
					}
				if (txtEmailAddress.getText().equals(txtReenterEmailAddress.getText()) && (passwordField.getText().equals(passwordField_1.getText()) 
						&& (!passwordField.getText().equals("")) && (!passwordField_1.getText().equals("")))) try {
					InternetAddress emailAddress = new InternetAddress(reciever);
					emailAddress.validate(); try {
			                Authenticator auth = new Authenticator() {
			                    public PasswordAuthentication getPasswordAuthentication() {
			                        return new PasswordAuthentication("FoodWise11@gmail.com", "FoodIsGreat@Portsmouth!");
			                    }
			                };
			                String createAccountQuery = "INSERT INTO login (username, password) VALUES ('"+txtReenterEmailAddress.getText()+"', '"+passwordField.getText()+"')";
			                connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
			                ((Connection)connect).createStatement().execute(createAccountQuery);
			                Session session = Session.getInstance(properties, auth);
			                Message email = new MimeMessage(session);
			                email.setFrom(new InternetAddress("FoodWise11@gmail.com"));            
			                email.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
			                email.setSentDate(new Date());
			                email.setSubject("Foodwise Account Creation");
			                email.setText("Your Account has been successfully created!, your password is:" + passwordField.getText());
			                Transport.send(email); 
			                System.out.println("email has been sent");
			                
			                ((java.sql.Connection)connect).close();
			                } catch (Exception x)
					{
						x.printStackTrace();
					}
				} catch (Exception E) {
					E.printStackTrace();
				}
					else {
						System.out.println("test fail");
				}
			}}
		});
		
		//password comparison checker between pass1 & pass2 
		
		passwordField.getDocument().addDocumentListener(new DocumentListener() {
				  public void changedUpdate(DocumentEvent e) {
				    Updated();
				  }
				  public void removeUpdate(DocumentEvent e) {
					Updated();
				  }
				  public void insertUpdate(DocumentEvent e) {
					Updated();
				  }
		
		public void Updated() {
		     if (passwordField.getText().equals(passwordField_1.getText())){
		    	 txtValidation.setText("Password comparison successful");
		    	 System.out.println("comparison successful ");
		     } 
		     else {
		    	 txtValidation.setText("Make sure to re-enter your password!");
		     }
		    }});
		
		//password comparison checker between pass2 & pass1
		
		passwordField_1.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				Updated();
			  }
			  public void removeUpdate(DocumentEvent e) {
				Updated();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  Updated();
			  }
	
			
		public void Updated() {
		     if (passwordField_1.getText().equals(passwordField.getText())){
		    	 txtValidation.setText("Looks good!");
		     } 
		     else {
		    	 txtValidation.setText("Passwords do not match up!");
		     }
		    }});
	
		//email comparison checker between email1 & email2.
		
		txtEmailAddress.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    Updated();
			  }
			  public void removeUpdate(DocumentEvent e) {
				Updated();
			  }
			  public void insertUpdate(DocumentEvent e) {
				Updated();
			  }
		public void Updated() {
		String email = txtEmailAddress.getText();
			if (txtEmailAddress.getText().equals(txtReenterEmailAddress.getText())){ try {
				InternetAddress emailAddress = new InternetAddress(email);
	    		emailAddress.validate();
	    		System.out.println("successful comparison, successful validation "); 
	    		txtrEmailValidationCheck.setText("Looks good!");
	    		} catch (Exception e) {
	    			System.out.println("successful comparison, unsuccessful validation");
	    			txtrEmailValidationCheck.setText("make sure to set a valid email address");
	    				if (txtEmailAddress.getText().equals("") && txtEmailAddress.getText().equals("")) {
	    					txtrEmailValidationCheck.setText("Please enter an email address!");
	    				}
	    			}
	    		}
			else if(!txtReenterEmailAddress.getText().equals(txtEmailAddress.getText())) {
				txtrEmailValidationCheck.setText("Make sure to re-enter your email address!");
			} else {
				txtrEmailValidationCheck.setText("Email addresses do not match");
			}
			}

		});
		
		//email comparison checker between email2 & email1.

		txtReenterEmailAddress.getDocument().addDocumentListener(new DocumentListener() {
		public void changedUpdate(DocumentEvent e) {
			Updated();
			}
		public void removeUpdate(DocumentEvent e) {
			Updated();
			}
		public void insertUpdate(DocumentEvent e) {
			Updated();
			}
		public void Updated() {
		String email = txtEmailAddress.getText();
			if (txtReenterEmailAddress.getText().equals(txtEmailAddress.getText())){ 
				try {
					InternetAddress emailAddress = new InternetAddress(email);
					emailAddress.validate();
					System.out.println("successful comparison, successful validation ");
					txtrEmailValidationCheck.setText("Looks good!");
	    			} catch (Exception e) {
	    				System.out.println("successful comparison, unsuccessful validation");
	    				txtrEmailValidationCheck.setText("Make sure to set a valid email address");
	    			}
	    		}
			else {
				txtrEmailValidationCheck.setText("Email addresses do not match!");
			}
			}
		
		});
		
		
		
	}
}


	    
		


	



