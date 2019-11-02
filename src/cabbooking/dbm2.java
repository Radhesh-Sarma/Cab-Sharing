/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Radhesh
 */
public class dbm2 {
    
       Connection conn=null;
    public static Connection dbconnect(){ 
    
  
    try
    {
    Class.forName("org.sqlite.JDBC");
    Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Radhesh\\Desktop\\Cab Sharing Patch\\1edit-20191026T180150Z-001\\1edit\\CabBooking\\databases\\driver.sqlite");
    //JOptionPane.showMessageDialog(null ,"connected");
    return conn;
}catch(Exception e){
    JOptionPane.showMessageDialog(null ,e);
    return null;
}
}
    
}
