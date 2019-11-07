/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class TransactionHistory extends javax.swing.JFrame {

    /**
     * Creates new form TransactionHistory
     */
            String rname;
         Connection connect = null;
ResultSet rs = null;
PreparedStatement pst = null;
 String userid;
    public TransactionHistory(String uid) {
        initComponents();
        connect=dbm.dbconnect();
        userid = uid;
        
           String query3="SELECT NAME FROM customer where USERNAME=?";
        PreparedStatement ps=null;
        try {
            ps = connect.prepareStatement(query3);
            ps.setString(1, userid);
            rs=ps.executeQuery();
            rname=rs.getString("name");
            hi.setText(rname);
            
        } catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
            //Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
           finally {
    try { if (rs != null) rs.close(); } catch (Exception e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (Exception e) {System.out.println(e.getMessage());}
    try { if (connect != null) connect.close(); } catch (Exception e) {System.out.println(e.getMessage());}
}
        
        
        int numberofbookings = 0;
        
            Connection conn = null ;
         ps = null;
         rs = null;
        try
        {
            conn = dbm3.dbconnect();
             String query="SELECT * FROM booking WHERE USERNAME = ?";
             ps =conn.prepareStatement(query);
             ps.setString(1, userid);
             rs=ps.executeQuery();
             
             while(rs.next())
             {
                 numberofbookings++;
             }
        }
         catch (Exception ex) 
        {
            System.out.println( ex.getMessage());
        }
          finally {
    try { if (rs != null) rs.close(); } catch (Exception e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (Exception e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (Exception e) {System.out.println(e.getMessage());}
}
        
        
         conn = null ;
         ps = null;
         rs = null;
         
          try
        {
             conn = dbm3.dbconnect();
             String query="SELECT * FROM booking WHERE USERNAME = ?";
             ps =conn.prepareStatement(query);
             ps.setString(1, userid);
             int i = 0 ;
             Object[] cname={"Reference Number","User ID","Driver ID","Pickup Location","Drop Location","Fare","Trip Start Time","Trip End Time"};
            DefaultTableModel model=new DefaultTableModel(cname,numberofbookings);
            table.setModel(model);
            
               rs=ps.executeQuery();
              while(rs.next())
              {
                String referencenumber = rs.getString("REFERENCENUMBER");
                String username = rs.getString("USERNAME");
                int driverid = rs.getInt("DRIVERID");
                String pickuplocation = HeadQuater.getLocationDescription(Integer.parseInt(rs.getString("PICKUPLOCATION")));
                String droplocation = HeadQuater.getLocationDescription(Integer.parseInt(rs.getString("DROPLOCATION")));
                int  tripstarttime = rs.getInt("TRIPSTARTTIME");
                int  tripendtime = rs.getInt("TRIPENDTIME");
                

                table.setValueAt((Object)(referencenumber),i,0);
                table.setValueAt((Object)(username),i,1);
                table.setValueAt((Object)(driverid),i,2);
                table.setValueAt((Object)(pickuplocation),i,3);
                table.setValueAt((Object)(droplocation),i,4);
                table.setValueAt((Object)(HeadQuater.CalculateFare(pickuplocation, droplocation)),i,5);
                table.setValueAt((Object)(tripstarttime),i,6);
                table.setValueAt((Object)(tripendtime),i,7);

                i++;
              }
        }
        catch (SQLException | NumberFormatException ex) 
        {
            System.out.println( ex.getMessage());
        }
          finally {
    try { if (rs != null) rs.close(); } catch (Exception e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (Exception e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (Exception e) {System.out.println(e.getMessage());}
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

        jLabel2 = new javax.swing.JLabel();
        hi1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        hi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Welcome");

        hi1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        hi1.setText("User_name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Your Transaction History is");

        Back.setBackground(new java.awt.Color(51, 51, 51));
        Back.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Welcome");

        hi.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        hi.setForeground(new java.awt.Color(204, 255, 255));
        hi.setText("User_name");

        table.setBackground(new java.awt.Color(14, 140, 214));
        table.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reference Number", "User ID", "Driver ID", "Pickup Location", "Drop Location", "Fare", "Trip Start Time", "Trip End Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setEnabled(false);
        table.setGridColor(new java.awt.Color(14, 140, 214));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hi, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
     
         new Functions(userid).setVisible(true); 
        this.setVisible(false); 
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    /**1111
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
            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel hi;
    private javax.swing.JLabel hi1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
