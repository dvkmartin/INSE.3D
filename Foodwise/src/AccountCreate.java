import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

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
		
		JTextArea txtrValidationCheckHereemail = new JTextArea();
		txtrValidationCheckHereemail.setText("validation check here/email sent to address");
		txtrValidationCheckHereemail.setBounds(10, 228, 364, 22);
		frmFoodwise.getContentPane().add(txtrValidationCheckHereemail);
		
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
		
		String password = passwordField.getPassword().toString();
		String password2 = passwordField_1.getPassword().toString();
		

				

		
	}
}
