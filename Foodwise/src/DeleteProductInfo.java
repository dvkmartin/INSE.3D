/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import javax.swing.JOptionPane;

/**
 * @author INSE3D
 */
public class DeleteProductInfo extends javax.swing.JFrame {

    /**
     * Creates new form DeleteProductInfo
     * @param userid
     */
    public DeleteProductInfo(int userid) {
        this.userid = userid;
        initComponents();
        //getDate();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deleteProductName = new javax.swing.JTextField();
        searchProductDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(406, 140));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 70, -1));

        jLabel1.setText("    Product Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 98, 23));

        deleteProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductNameActionPerformed(evt);
            }
        });
        getContentPane().add(deleteProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 284, -1));

        searchProductDelete.setText("Search");
        searchProductDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(searchProductDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 70, -1));

        jLabel2.setText("(Copy and paste the chosen product across for removal).");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes current frame
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /** 
     * Deletes a users product information based on user input
     * @param evt 
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String delete = ("DELETE FROM user_details WHERE user_id = " + userid + " AND product_detail = ('" + deleteProductName.getText() + "')");
        if (deleteProductName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the product information for the product you would like to delete");
        }
        if (!deleteProductName.getText().equals("")) {
            try {
                connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
                Statement stmt = ((Connection) connect).createStatement();
                stmt.execute(delete);
                JOptionPane.showMessageDialog(null, "Product deleted if product information match");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void deleteProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductNameActionPerformed

    }//GEN-LAST:event_deleteProductNameActionPerformed

    /**
     * Searches to see whether a product is ready for deletion. 
     * @param evt 
     */
    private void searchProductDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductDeleteActionPerformed
        String editProductBuilder = deleteProductName.getText();
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
                    JOptionPane.showMessageDialog(null, "Item lookup successful");
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

    }//GEN-LAST:event_searchProductDeleteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField deleteProductName;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchProductDelete;
    // End of variables declaration//GEN-END:variables
}
