import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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

public class AccountCreate {

	private JFrame frmFoodwise;
	private JTextField txtEmailAddress;
	private JTextField txtReenterEmailAddress;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreate window = new AccountCreate();
					window.frmFoodwise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodwise = new JFrame();
		frmFoodwise.setTitle("Foodwise");
		frmFoodwise.setBounds(100, 100, 400, 300);
		frmFoodwise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodwise.getContentPane().setLayout(null);
		frmFoodwise.setResizable(false);
		
		JLabel lblCreateAnAccount = DefaultComponentFactory.getInstance().createLabel("Create an Account");
		lblCreateAnAccount.setBounds(180, 25, 116, 14);
		frmFoodwise.getContentPane().add(lblCreateAnAccount);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setToolTipText("Username");
		txtEmailAddress.setBounds(148, 50, 175, 20);
		frmFoodwise.getContentPane().add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		txtReenterEmailAddress = new JTextField();
		txtReenterEmailAddress.setToolTipText("Re-enter Email Address");
		txtReenterEmailAddress.setColumns(10);
		txtReenterEmailAddress.setBounds(148, 81, 175, 20);
		frmFoodwise.getContentPane().add(txtReenterEmailAddress);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setBounds(165, 174, 131, 23);
		frmFoodwise.getContentPane().add(btnCreateAccount);
		
		JTextArea txtValidation = new JTextArea();
		txtValidation.setBounds(10, 238, 364, 22);
		frmFoodwise.getContentPane().add(txtValidation);
		
		JLabel lblUsername = DefaultComponentFactory.getInstance().createLabel("Email Address");
		lblUsername.setBounds(57, 53, 88, 14);
		frmFoodwise.getContentPane().add(lblUsername);
		
		JLabel lblPassword = DefaultComponentFactory.getInstance().createLabel("Password");
		lblPassword.setBounds(81, 115, 64, 14);
		frmFoodwise.getContentPane().add(lblPassword);
		
		JLabel lblReenterEmailAddress = DefaultComponentFactory.getInstance().createLabel("Re-enter Email Address");
		lblReenterEmailAddress.setBounds(10, 84, 147, 14);
		frmFoodwise.getContentPane().add(lblReenterEmailAddress);
		
		JLabel lblReenterPassword = DefaultComponentFactory.getInstance().createLabel("Re-enter Password");
		lblReenterPassword.setBounds(28, 146, 117, 14);
		frmFoodwise.getContentPane().add(lblReenterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 112, 175, 20);
		frmFoodwise.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(148, 143, 175, 20);
		frmFoodwise.getContentPane().add(passwordField_1);
		
		JTextArea txtrEmailValidationCheck = new JTextArea();
		txtrEmailValidationCheck.setText("Please enter your email address!");
		txtrEmailValidationCheck.setBounds(10, 208, 364, 22);
		frmFoodwise.getContentPane().add(txtrEmailValidationCheck);
		
		
		// checks making sure all both repeating fields have the same values. Method Resolves if true. 
		
		btnCreateAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
				if(passwordField.getText().equals("")) {
					txtValidation.setText("Please enter your password!");
						}
				if(txtEmailAddress.getText().equals("")) {
					txtrEmailValidationCheck.setText("Please enter your email address!");
					}
				else if (passwordField.getText().equals(passwordField_1.getText()) && (txtEmailAddress.getText().equals(txtReenterEmailAddress.getText()))) {
					txtValidation.setText("test success");
					System.out.println("test success");
					// this is where  clicking create account the info provided by the user will be appended into the database 
				}	else {
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
			@Override
			  public void changedUpdate(DocumentEvent e) {
				Updated();
			  }
			@Override
			  public void removeUpdate(DocumentEvent e) {
				Updated();
			  }
			@Override
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
			try {
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
				txtrEmailValidationCheck.setText("Email addresses do not match!");
			} else {
				txtrEmailValidationCheck.setText("Make sure to re-enter your email address");
			}
			}
		 catch (Exception e) { //never resolves
			System.out.println("test failed try if statement");
		}
		}});
		
		//email comparison checker between email2 & email1.

		txtReenterEmailAddress.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			  public void changedUpdate(DocumentEvent e) {
			    Updated();
			  }
			@Override
			  public void removeUpdate(DocumentEvent e) {
				Updated();
			  }
			@Override
			  public void insertUpdate(DocumentEvent e) {
				Updated();
			  }
		
		public void Updated() {
		String email = txtEmailAddress.getText();
		try {
			if (txtReenterEmailAddress.getText().equals(txtEmailAddress.getText())){ try {
				InternetAddress emailAddress = new InternetAddress(email);
	    		emailAddress.validate();
	    		System.out.println("successful comparison, successful validation ");
	    		txtrEmailValidationCheck.setText("Looks good!");
	    		} catch (Exception e) {
	    			System.out.println("successful comparison, unsuccessful validation");
	    			txtrEmailValidationCheck.setText("make sure to set a valid email address");
	    			}
	    		}
			else {
				txtrEmailValidationCheck.setText("Email addresses do not match!");
			}
			}
		 catch (Exception e) { //never resolves
			System.out.println("test failed try if statement");
		}
		}
		});
	}
}

	    
		


	



