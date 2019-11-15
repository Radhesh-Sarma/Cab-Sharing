/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.Timer;
/**
 *
 * @author Radhesh
 */
public class CabBookingApplication extends javax.swing.JFrame {

        
    /**
     * Creates new form CabBookingApplication
     */
    public CabBookingApplication() {
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
       
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(login);
        
           Timer timer = new Timer();
           if(new Scheduler().scheduledExecutionTime()==0)
        {
            timer.schedule(new Scheduler(),1000,30000);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_user_id = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        sign_up = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.blue);
        setForeground(new java.awt.Color(0, 0, 153));
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1900, 1180));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cab Booking Portal");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(744, 12, 345, 58);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User ID:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(537, 260, 152, 26);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(537, 428, 152, 30);

        txt_user_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_user_id.setToolTipText("");
        txt_user_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_user_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_user_idFocusLost(evt);
            }
        });
        txt_user_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_user_idActionPerformed(evt);
            }
        });
        jPanel1.add(txt_user_id);
        txt_user_id.setBounds(1092, 253, 240, 33);

        login.setBackground(java.awt.Color.darkGray);
        login.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        login.setForeground(java.awt.Color.white);
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(612, 721, 569, 59);

        sign_up.setBackground(java.awt.Color.darkGray);
        sign_up.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        sign_up.setForeground(java.awt.Color.white);
        sign_up.setText("Sign Up");
        sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_upActionPerformed(evt);
            }
        });
        jPanel1.add(sign_up);
        sign_up.setBounds(520, 920, 710, 73);

        txt_password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txt_password);
        txt_password.setBounds(1092, 433, 240, 30);

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(1092, 469, 164, 26);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New User?");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(820, 880, 130, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        
        if("Enter User ID".equals(txt_user_id.getText())){
        JOptionPane.showMessageDialog(null, "Enter Valid User ID");
        }
        else if(txt_password.getPassword().length==0){
        JOptionPane.showMessageDialog(null, "Enter Valid Password");
        }
        else if(HeadQuater.isAdminUser(txt_user_id.getText()))
        {
           if(HeadQuater.isAdminPasswordCorrect(txt_user_id.getText(), String.valueOf(txt_password.getPassword())))
           {
               new Admin(txt_user_id.getText()).setVisible(true);
               this.dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Wrong Password");
           }
            
        }

        else if(HeadQuater.doesUserIdExists(txt_user_id.getText()) == false && (!(HeadQuater.isAdminUser(txt_user_id.getText()))))
        {
            
            JOptionPane.showMessageDialog(null, "Given User ID does not exist");
        }
        else if(HeadQuater.isCustomerPasswordCorrect(txt_user_id.getText(),String.valueOf(txt_password.getPassword())))
        {
            Customer ob = HeadQuater.retriveCustomerData(txt_user_id.getText());
            this.setVisible(false);
            new Functions(ob).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Password");
        }
              // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void txt_user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_user_idActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_user_idActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            txt_password.setEchoChar((char)0);
        }else
        txt_password.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txt_user_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusGained
        // TODO add your handling code here:
          if(txt_user_id.getText().equals("Enter User ID")){
        txt_user_id.setText(null);
        txt_user_id.setForeground(Color.BLACK);
    }
    }//GEN-LAST:event_txt_user_idFocusGained

    private void txt_user_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusLost
       // TODO add your handling code here:
          if(txt_user_id.getText().equals("")){
            txt_user_id.setForeground(new Color(204,204,204));
        txt_user_id.setText("Enter User ID");
    } 
    }//GEN-LAST:event_txt_user_idFocusLost

    private void sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_upActionPerformed
        this.setVisible(false);
        new SignupPage().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_sign_upActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CabBookingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CabBookingApplication().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JButton login;
    private javax.swing.JButton sign_up;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user_id;
    // End of variables declaration//GEN-END:variables
}
