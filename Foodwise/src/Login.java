import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Login {

	private JFrame frmFoodwise;
	private JTextField txtUsername;
	private JTextField txtPasword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodwise = new JFrame();
		frmFoodwise.setTitle("Foodwise");
		frmFoodwise.setBounds(100, 100, 450, 300);
		frmFoodwise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodwise.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(124, 47, 188, 20);
		frmFoodwise.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPasword = new JTextField();
		txtPasword.setText("Password");
		txtPasword.setColumns(10);
		txtPasword.setBounds(124, 78, 188, 20);
		frmFoodwise.getContentPane().add(txtPasword);
		
		JLabel lblFoodwise = DefaultComponentFactory.getInstance().createTitle("Foodwise");
		lblFoodwise.setBounds(192, 22, 92, 14);
		frmFoodwise.getContentPane().add(lblFoodwise);
		
		JButton btnLoginWithFacebook = new JButton("Login with Facebook");
		btnLoginWithFacebook.setBounds(133, 148, 164, 23);
		frmFoodwise.getContentPane().add(btnLoginWithFacebook);
		
		JLabel lblNeedAnAccount = DefaultComponentFactory.getInstance().createLabel("Need an account? ");
		lblNeedAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeedAnAccount.setBounds(159, 182, 115, 14);
		frmFoodwise.getContentPane().add(lblNeedAnAccount);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(144, 114, 142, 23);
		frmFoodwise.getContentPane().add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(169, 207, 89, 23);
		frmFoodwise.getContentPane().add(btnSignUp);
	}
}
