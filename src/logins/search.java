/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author shadrak
 */
public class search extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    String book,person;
    
    
    /**
     * Creates new form search
     */
    public search() {
        initComponents();
       // fetch(String x);
    }
    static String uname;
     public void odd(String name) {
        uname = name;
    }
    
    public void fetch(String name){
        con = MySqlconnect.ConnectDB();
        try{
            String q = jComboBox1.getSelectedItem().toString();
            String s = "select * from BOOKS where "+q+" LIKE '%"+name+"%'";
            p = con.prepareStatement(s);
            rs = p.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bookid = new javax.swing.JTextField();
        buy = new javax.swing.JButton();
        searcharea = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 812, 569));
        setMinimumSize(new java.awt.Dimension(812, 569));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 110, 590, 390);

        title.setFont(new java.awt.Font("Century Schoolbook L", 3, 20)); // NOI18N
        title.setForeground(new java.awt.Color(238, 37, 37));
        title.setText("Books Available...");
        getContentPane().add(title);
        title.setBounds(310, 20, 300, 30);

        back.setBackground(new java.awt.Color(249, 152, 93));
        back.setFont(new java.awt.Font("Bitstream Charter", 3, 15)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(20, 20, 80, 31);

        logout.setBackground(new java.awt.Color(186, 29, 61));
        logout.setFont(new java.awt.Font("Bitstream Charter", 3, 15)); // NOI18N
        logout.setText("logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(640, 30, 90, 31);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 2, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 122, 196));
        jLabel1.setText("Enter the Book ID you want to buy:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 520, 290, 23);
        getContentPane().add(bookid);
        bookid.setBounds(350, 520, 130, 28);

        buy.setBackground(new java.awt.Color(120, 219, 92));
        buy.setFont(new java.awt.Font("Bitstream Charter", 3, 15)); // NOI18N
        buy.setForeground(new java.awt.Color(64, 150, 89));
        buy.setText("Buy");
        buy.setBorderPainted(false);
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });
        getContentPane().add(buy);
        buy.setBounds(500, 520, 90, 30);
        getContentPane().add(searcharea);
        searcharea.setBounds(230, 60, 260, 28);

        jButton1.setFont(new java.awt.Font("Bitstream Charter", 3, 15)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 60, 90, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Author", "Title ", "Price", "Conditions" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(120, 60, 100, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new logins.Welcome().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new logins.Login().setVisible(true);
        
    }//GEN-LAST:event_logoutActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
        // TODO add your handling code here:
        con = MySqlconnect.ConnectDB();
        try{
            //String s = "select * from BOOKS WHERE BOOKS_ID=?";
            int flag = 1;
            Statement st = con.createStatement();
            book = bookid.getText();
            ResultSet rs = st.executeQuery("select * from BOOKS_RECORD");
            while(rs.next()) {
               if(rs.getString(2).equals(bookid.getText())) {
                   flag = 0;
                   person = rs.getString(1);
                   break;
               }
            }  
            /*String query = "SELECT PERSON INTO @"+person+" FROM BOOKS_RECORD WHERE BOOKS = ? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,book);
            ps.executeQuery();*/
            //System.out.println(person);
            PreparedStatement ps2;
            JOptionPane.showMessageDialog(null, "Seller ID is "+person);
            String query1 = "Select * from PERSON where USERNAME = ?";
            String query2 = "select * from CONTACT_DETAILS where P_ID = ?";
            PreparedStatement ps = con.prepareStatement(query1);
            PreparedStatement ps1 = con.prepareStatement(query2);
            ps.setString(1,person);
            ps1.setString(1,person);
            ResultSet r = ps.executeQuery();
            ResultSet r1 = ps1.executeQuery();
            String name = "",contact = "",email = "";
            while(r.next()) {
                if(r.getString(2).equals(person)) {
                    name = r.getString(1);break;
                } 
            }
            while(r1.next()) {
                if(r1.getString(1).equals(person)) {
                    contact = r1.getString(2);
                    email = r1.getString(3);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null,"Your seller is "+name+". Contact Details are "+contact+" & "+email+".");
            JOptionPane.showMessageDialog(null,"THANKYOU FOR USING SHM !!!!!!");
            String query5 ="insert into BOOKS_HISTORY_R values(?,?,?) " ;
            //String query6 = "insert into BOOKS_HISTORY where BOOKS = ?";
            String query3 = "delete from BOOKS_RECORD where BOOKS = ?";
            String query4 = "delete from BOOKS where BOOKS_ID = ?";
           
           /* ps2= con.prepareStatement(query6);
            ps2.setString(1,book);
            ps2.setString(2,);
            ResultSet rs1 = ps2.prepareStatement("select * from BOOKS where BOOKS_ID = ?");
            ps2.setString(3,book);
            ps2.setString(4,book);
            ps2.setString(5,book);
            ps2.setString(6,book);*/
            
            ps2= con.prepareStatement(query3);
            ps2.setString(1,book);
            ps2.executeUpdate();
            ps2 = con.prepareStatement(query4);
            ps2.setString(1,book);
            ps2.executeUpdate();
            ps2 =  con.prepareStatement(query5); 
            ps2.setString(1,book);
            ps2.setString(2,uname);
            ps2.setString(3,person);
            ps2.executeUpdate();
            setVisible(false);
            new logins.Login().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }    
    }//GEN-LAST:event_buyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Bname = searcharea.getText();
        fetch(Bname);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField bookid;
    private javax.swing.JButton buy;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JTextField searcharea;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
