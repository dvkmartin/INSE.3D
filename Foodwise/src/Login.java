import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Wrapper;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;



public class Login extends JFrame{

	static final String JDBC_Driver = "com.mysql.jdbc.Driver";  
    static final String Database_Path = "jdbc:mysql://localhost:3306/new?verifyServerCertificate=false&useSSL=true";
    static final String DBUsername = "root";
    static final String DBPassword = "root";
	Wrapper connect = null;
	
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
		frmFoodwise = this;
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
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //compare db info
                            try{
		String selectquery  = "select user_id from login where username = '" +txtUsername.getText()+"' and password='"+txtPasword.getText()+"'";
                connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
                 Statement stmt=((Connection)connect).createStatement();
                 stmt.execute(selectquery);
                 ResultSet rs=stmt.getResultSet();
                 int userid=-1;
                 if(rs.next())
                     userid=rs.getInt(1);
                 if(userid>-1)
                 {
                     frmFoodwise.setVisible(false);
                     frmFoodwise.dispose();
                     //pass the userid to the new Home form
                     (new Home(userid)).setVisible(true);
                 }
                 System.out.println("User id:"+userid);
                 ((java.sql.Connection)connect).close();
                            }catch(Exception ex)
                            {
                                System.out.println(ex.getStackTrace());
                            }
			}
		});
		
		btnSignIn.setBounds(144, 114, 142, 23);
		frmFoodwise.getContentPane().add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFoodwise.setVisible(false);
				frmFoodwise.dispose();
				new AccountCreate().setVisible(true);
				
			}
		});
		btnSignUp.setBounds(169, 207, 89, 23);
		frmFoodwise.getContentPane().add(btnSignUp);
		
		
	}
}
