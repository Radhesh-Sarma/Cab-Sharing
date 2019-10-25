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
public class dbm {
    
       Connection conn=null;
    public static Connection dbconnect(){ 
    
  
    try
    {
    Class.forName("org.sqlite.JDBC");
    Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Radhesh\\Documents\\NetBeansProjects\\CabBooking\\databases\\customer.sqlite");
    //JOptionPane.showMessageDialog(null ,"connected");
    return conn;
}catch(Exception e){
    JOptionPane.showMessageDialog(null ,e);
    return null;
}
}
    
}
