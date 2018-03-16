
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import javax.swing.JOptionPane;

/**
 *
 * @author INSE3D
 */
public class EditProductInfo extends javax.swing.JFrame {

    /**
     * Creates new form EditProductInfo
     * @param userid 
     */
    public EditProductInfo(int userid) {
        this.userid = userid;
        initComponents();
        getDate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String Database_Path = "jdbc:mysql://167.99.88.104:3306/new?verifyServerCertificate=false&useSSL=true";
    static final String DBUsername = "foodwiseAdmin";
    static final String DBPassword = "Inse3d..";
    Wrapper connect = null;
    private int userid = -1;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jCalendar = new com.toedter.calendar.JCalendar();
        EditProductbtn = new javax.swing.JButton();
        labelGetDate = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PreviousProduct = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ItemLookupBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("New Product Name: ");

        productName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose a category");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Vegetable");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Fruit");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Grain");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Meat");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Milk");

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("Juice");

        EditProductbtn.setText("Edit Item");
        EditProductbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductbtnActionPerformed(evt);
            }
        });

        labelGetDate.setText("Product Expiration Date: ");

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Previous Product Infomation: ");

        PreviousProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousProductActionPerformed(evt);
            }
        });

        jLabel4.setText("(Copy and paste the chosen product across from homepage for removal).");

        ItemLookupBtn.setText("Item Lookup");
        ItemLookupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemLookupBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 232, Short.MAX_VALUE)
                        .addComponent(EditProductbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PreviousProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ItemLookupBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelGetDate)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton5)
                        .addComponent(jRadioButton6)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel3)))
                    .addGap(7, 383, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemLookupBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditProductbtn))
                .addGap(38, 38, 38)
                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(151, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jRadioButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jRadioButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jRadioButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jRadioButton4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jRadioButton5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jRadioButton6)
                    .addGap(39, 39, 39)
                    .addComponent(labelGetDate)
                    .addGap(17, 17, 17)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sets the date to a JLabel that the user can select
     */
    private void getDate() {
        labelGetDate.setText("Date Expiration: " + jCalendar.getDate().toString());
        jCalendar.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                labelGetDate.setText("Date Expiration: " + jCalendar.getDate().toString());

            }
        });
    }

    /**
     * @param evt On click button will edit a product based on user inputted
     * details
     */
    private void EditProductbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductbtnActionPerformed
        jRadioButton1.setActionCommand("Vegetable  ");
        jRadioButton2.setActionCommand("Fruit  ");
        jRadioButton3.setActionCommand("Grain  ");
        jRadioButton4.setActionCommand("Meat  ");
        jRadioButton5.setActionCommand("Milk  ");
        jRadioButton6.setActionCommand("Juice  ");
        if (PreviousProduct.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your product information to edit");
        }
        else if (productName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter a product name!!");
        } 
        else if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Select a product type!");
        }
        if (!productName.getText().equals("") && (!PreviousProduct.getText().equals(""))) {
            String productBuilder = (productName.getText() + "   " + labelGetDate.getText());
            String productType = buttonGroup1.getSelection().getActionCommand();
            try {
                String insertProductQuery = ("UPDATE user_details SET product_detail = ('" + productType + " " + productBuilder + "') where user_id = " + userid + " AND product_detail = ('" + PreviousProduct.getText() + "')");
                connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
                Statement stmt = ((Connection) connect).createStatement();
                stmt.execute(insertProductQuery);
                JOptionPane.showMessageDialog(null, "Item succcessfully edited!");
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_EditProductbtnActionPerformed
    /**
     * Closes current frame
     * @param evt
     */
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameActionPerformed

    /**
     * Checks the item exists in the database. Acts as a reference to editing a
     * product.
     * @param evt
     */
    private void ItemLookupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemLookupBtnActionPerformed
        String editProductBuilder = PreviousProduct.getText();
        {
            try {
                String itemLookUp = "select product_detail from user_details where user_id = " + userid + " AND product_detail = ('" + editProductBuilder + "')  order by id desc";
                connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
                Statement stmt = ((Connection) connect).createStatement();
                stmt.execute(itemLookUp);
                ResultSet rs = stmt.getResultSet();
                if (rs.next()) {
                    String result = rs.getString("product_detail");
                    System.out.println(result);
                    JOptionPane.showMessageDialog(null, "Item lookup successfull");
                } else {
                    JOptionPane.showMessageDialog(null, "Item lookup unsuccessful, re-enter your product information");
                }
                rs.close();
                stmt.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Item lookup unsuccessful, re-enter your product information");
                System.out.println(ex);

            }

        }
    }//GEN-LAST:event_ItemLookupBtnActionPerformed

    private void PreviousProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousProductActionPerformed

    //String createAccountQuery = "INSERT INTO login (username, password) VALUES" + " ('" + txtReenterEmailAddress.getText() + "', '" + passwordField.getText() + "')";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditProductbtn;
    private javax.swing.JButton ItemLookupBtn;
    private javax.swing.JTextField PreviousProduct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelBtn;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JLabel labelGetDate;
    public static javax.swing.JTextField productName;
    // End of variables declaration//GEN-END:variables
}