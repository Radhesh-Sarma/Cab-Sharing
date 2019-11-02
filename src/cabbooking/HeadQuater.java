/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Radhesh
 */


public class HeadQuater 
{
    
    public static int CalculateFare(int x1,int y1,int x2,int y2)
    {
        return 8*(Math.abs(x1-x2) + Math.abs(y1-y2));
    }
    
    public static boolean isCabAvailable()
    {
        
        boolean answer = false;
        
        
      Connection connect = null;
      ResultSet rs = null;
      PreparedStatement ps = null;
      
      connect = dbm2.dbconnect();
      
      
      try
      {
          String sql = "SELECT LOCATION_X,LOCATION_Y FROM driver WHERE ISBUSY =0";
      
            ps =connect.prepareStatement(sql);
              rs=ps.executeQuery();
              
              while(rs.next())
              {
        
                  answer = true;    
              }
      }
        catch(Exception e){
            //System.out.println(e.getMessage());
        }finally{
            try{
                rs.close();
                ps.close();
            }catch(Exception e){
                
            }
        }
      
               
        
        return answer;
    }
    
    public static boolean CanBookCab(String uid,int fare)
    {
        boolean answer = true;
        
         Connection connect = null;
      ResultSet rs = null;
      PreparedStatement ps = null;
      
      connect = dbm.dbconnect();
      
      
      try
      {
     
          String sql = "SELECT BALANCE FROM customer WHERE USERNAME=?";
          
            ps =connect.prepareStatement(sql);
            ps.setString(1,uid);
              rs=ps.executeQuery();
              
              double bal = rs.getDouble("balance");
              if(bal < 300 || bal < fare)
              {
                  answer = false;
              }
              
              
              
              
      }
        catch(Exception e){
            //System.out.println(e.getMessage());
        }finally{
            try{
                rs.close();
                ps.close();
            }catch(Exception e){
                
            }
        }
        
        return answer;
    }
    
}
