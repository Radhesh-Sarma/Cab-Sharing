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
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author Dell
 */


public class Rating extends javax.swing.JFrame {

    Customer currentuser;
    String rating;
    /**
     * Creates new form Rating
     * @param ob
     */
    public Rating(Customer ob) {
        initComponents();
        currentuser = ob;
        
         int numberofbookings = 0;
        
            Connection conn = null ;
         PreparedStatement ps = null;
         ResultSet rs = null;
        try
        {
            conn = dbm3.dbconnect();
             String query="SELECT * FROM booking WHERE USERNAME = ?";
             ps =conn.prepareStatement(query);
             ps.setString(1,ob.getUsername());
             rs=ps.executeQuery();
             
             while(rs.next())
             {
                 numberofbookings++;
             }
        }
         catch (SQLException ex) 
        {
            System.out.println( ex.getMessage());
        }
          finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
        
             conn = null;
        ps = null;
         rs = null;
          try
        {
            
             conn = dbm3.dbconnect();
             String query="SELECT * FROM booking WHERE USERNAME = ?";
             ps =conn.prepareStatement(query);
             ps.setString(1, ob.getUsername());
             int i = 0 ;
             Object[] cname={"Reference Number","User ID","Driver ID","Pickup Location","Drop Location","Fare","Trip Start Time","Trip End Time","Rating"};
            DefaultTableModel model=new DefaultTableModel(cname,numberofbookings);
            table.setModel(model);
            
               rs=ps.executeQuery();
              while(rs.next())
              {
                String referencenumber = rs.getString("REFERENCENUMBER");
                String username = rs.getString("USERNAME");
                int driverid = rs.getInt("DRIVERID");
                System.out.println(rs.getString("DROPLOCATION"));
                String pickuplocation = HeadQuater.getLocationDescription(Integer.parseInt(rs.getString("PICKUPLOCATION")));
                String droplocation = HeadQuater.getLocationDescription(Integer.parseInt(rs.getString("DROPLOCATION")));
                String  tripstarttime = rs.getString("TRIPSTARTTIME");
                String  tripendtime = rs.getString("TRIPENDTIME");
               rating = String.valueOf(rs.getInt("RATING"));
                System.out.println(referencenumber + " " + username + " "  + driverid);
                table.setValueAt((Object)(referencenumber),i,0);
                table.setValueAt((Object)(username),i,1);
                table.setValueAt((Object)(driverid),i,2);
                table.setValueAt((Object)(pickuplocation),i,3);
                table.setValueAt((Object)(droplocation),i,4);
                table.setValueAt((Object)(HeadQuater.CalculateFare(pickuplocation, droplocation)),i,5);
                table.setValueAt((Object)(tripstarttime),i,6);
                table.setValueAt((Object)(tripendtime),i,7);
                table.setValueAt((Object)(rating),i,8);
                

                i++;
              }
              
             table.enable(true);
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    if(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString()!=null)
                    {
                         rating =table.getValueAt(table.getSelectedRow(),8).toString();
                       // System.out.println(rating);
                    }
                }
            });
              
              
             
        }
        catch (SQLException | NumberFormatException ex) 
        {
            System.out.println( ex.getMessage());
        }
          finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
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

        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        modifyRating = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton5.setText("1");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), new java.awt.Color(204, 204, 204)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(2000, 1200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     Thank you for riding with us!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Please rate your experience with the driver!");

        table.setBackground(java.awt.Color.darkGray);
        table.setFont(new java.awt.Font("Caviar Dreams", 1, 20)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reference Number", "User ID", "Driver ID", "Pickup Location", "Drop Location", "Fare", "Trip Start Time", "Trip End Time", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setEnabled(false);
        table.setGridColor(java.awt.Color.black);
        table.setRowHeight(30);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        Back.setBackground(java.awt.Color.darkGray);
        Back.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        Back.setForeground(java.awt.Color.white);
        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        modifyRating.setBackground(java.awt.Color.darkGray);
        modifyRating.setFont(new java.awt.Font("Ubuntu", 1, 30)); // NOI18N
        modifyRating.setForeground(java.awt.Color.white);
        modifyRating.setText("Modify Rating");
        modifyRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRatingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(679, 679, 679)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(567, 567, 567)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)
                                .addComponent(modifyRating, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(590, 590, 590)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 644, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyRating, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(192, 192, 192))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new Functions(currentuser).setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void modifyRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRatingActionPerformed
        // TODO add your handling code here:
         
             String newrating =table.getValueAt(table.getSelectedRow(),8).toString();
             String driverid = table.getValueAt(table.getSelectedRow(),2).toString();
             String bookingref = table.getValueAt(table.getSelectedRow(),0).toString();
             
             
              int nwrating = Integer.parseInt(newrating);
              Driver ob = HeadQuater.retriveDriverData(Integer.parseInt(driverid));
              
              
              Booking currentbooking = HeadQuater.retriveBookingData(bookingref);
              System.out.print(nwrating);
              
              if(nwrating < 1 || nwrating >5)
              {
                  JOptionPane.showMessageDialog(null, "Rating is between 1 and 5");
              }
              else
              {
                  HeadQuater.modifydriverrating(nwrating,ob,currentbooking);
                  JOptionPane.showMessageDialog(null, "Rating for Trip is Updated");
              }
              
    }//GEN-LAST:event_modifyRatingActionPerformed

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
                UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //new Rating().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyRating;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
