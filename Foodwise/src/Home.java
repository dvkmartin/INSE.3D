
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Wrapper;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
public class Home extends JFrame{

    static final String JDBC_Driver = "com.mysql.jdbc.Driver";  
    static final String Database_Path = "jdbc:mysql://localhost:3306/new?verifyServerCertificate=false&useSSL=true";
    static final String DBUsername = "root";
    static final String DBPassword = "root";
    private int userid=-1;
    
    private JFrame frmHome;
    private JTextField txtProductDetails;
    Wrapper connect = null;
    public Home(){
        initialize();
    }
    //get the userid from the login form
    public Home(int userid)
    {
        this.userid=userid;
        initialize();
    }
    private void initialize(){
        frmHome = new JFrame();
		frmHome = this;
		frmHome.setTitle("Foodwise");
		frmHome.setBounds(100, 100, 450, 300);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		txtProductDetails = new JTextField();
		txtProductDetails.setText("Product Details");
		txtProductDetails.setBounds(124, 47, 188, 20);
		frmHome.getContentPane().add(txtProductDetails);
		txtProductDetails.setColumns(10);
                JButton saveProductDetailsBtn = new JButton("Save Product" + "");
		saveProductDetailsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                                try{
                                String insertProductQuery = "INSERT INTO user_details (product_detail, user_id) VALUES ('"+txtProductDetails.getText()+"',"+userid+")";
			        connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
			        ((Connection)connect).createStatement().execute(insertProductQuery);
                                }
                                catch(Exception ex){
                                    System.out.println(ex);
                                }
                                frmHome.setVisible(false);
				frmHome.dispose();
				new Home(userid).setVisible(true);
				
			}
		});
                
                String lastInsertedProduct="";
                try{
                String selectquery  = "select product_detail from user_details where user_id = "+userid+" order by id desc";
                connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
                 Statement stmt=((Connection)connect).createStatement();
                 stmt.execute(selectquery);
                 ResultSet rs=stmt.getResultSet();
                
                 if(rs.next())
                     lastInsertedProduct=rs.getString(1);
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                JLabel lblLastProduct = DefaultComponentFactory.getInstance().createLabel("Last Inserted Product: "+lastInsertedProduct);
		lblLastProduct.setBounds(50, 120, 300, 20);
		frmHome.getContentPane().add(lblLastProduct);
		
		saveProductDetailsBtn.setBounds(130, 80, 140, 20);
                getContentPane().add(saveProductDetailsBtn);
    }
    
    
    
}
