/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.*; 

/**
 *
 * @author Radhesh
 */



public class HeadQuater 
{
    static int currenttime = 0;
  
    
    
    
   public static String getLocationDescription(int loc)
   {
       String answer = null;
       if(loc==1)
       {
           answer="Alwal";
       }
       if(loc==2)
       {
           answer="Banjara Hills";
       }
       if(loc==3)
       {
           answer="Bolaram";
       }
       if(loc==4)
       {
           answer="Dholakpur";
       }
       if(loc==5)
       {
           answer="East MaredPally";
       }
       if(loc==6)
       {
           answer="Firoz Nagar";
       }
       if(loc==7)
       {
           answer="Gandhi Marg";
       }
       if(loc==8)
       {
           answer="Hi Tech City";
       }
       if(loc==9)
       {
           answer="Kachiguda";
       }
       if(loc==10)
       {
           answer="Kompally";
       }
       if(loc==11)
       {
           answer="Nampally";
       }
       if(loc==12)
       {
           answer="Medchal";
       }
       if(loc==13)
       {
           answer="Malakpet";
       }
       if(loc==14)
       {
           answer="Ratna Nagar";
       }
       if(loc==15)
       {
           answer="Trimulgherry";
       }
       if(loc==16)
       {
           answer="West MaredPally";
       }
       
       return answer;
       
   
   }
    
    
    
  public static int getLocationNumber(String str)
     {
        // System.out.println(6);
       int answer = 0;
       if(str.equals("Alwal"))
       {
           answer=1;
       }
       if(str.equals("Banjara Hills"))
       {
           answer=2;
       }
       if(str.equals("Bolaram"))
       {
           answer=3;
       }
       if(str.equals("Dholakpur"))
       {
           answer=4;
       }
       if(str.equals("East MaredPally"))
       {
           answer=5;
       }
       if(str.equals("Firoz Nagar"))
       {
           answer=6;
       }
       if(str.equals("Gandhi Marg"))
       {
           answer=7;
       }
       if(str.equals("Hi Tech City"))
       {
           answer=8;
       }
       if(str.equals("Kachiguda"))
       {
           answer=9;
       }
       if(str.equals("Kompally"))
       {
           answer=10;
       }
       if(str.equals("Nampally"))
       {
           answer=11;
       }
       if(str.equals("Medchal"))
       {
           answer=12;
       }
       if(str.equals("Malakpet"))
       {
           answer=13;
       }
       if(str.equals("Ratna Nagar"))
       {
           answer=14;
       }
       if(str.equals("Trimulgherry"))
       {
           answer=15;
       }
       if(str.equals("West MaredPally"))
       {
           answer=16;
       }
       
       return answer;
       
   
   }
    
    
    
    
      public static int Distance(String pickup, String drop)
    {
        //System.out.println(5);
        return Math.abs(getLocationNumber(pickup) - getLocationNumber(drop));
    }
      
    public static int CalculateFare(String pickup, String drop)
    {
       // System.out.println(4);
        return 80*(Distance(pickup,drop));
    }
    
    public static boolean isCabAvailable()
    {
        
        boolean answer = false;
        
   
      
       
      
    
      try
      {
          
              
       Connection con= dbm2.dbconnect();
      
      String sql = "SELECT * FROM driver WHERE ISBUSY=? ";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1,0);
              ResultSet rs=ps.executeQuery();
              
              while(rs.next())
              {
        
                  answer = true;    
              }
      }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
               
        
        return answer;
    }
    
    public static boolean CanBookCab(String uid,int fare)
    {
        boolean answer = true;
       
      
      try
      {
      Connection con= dbm.dbconnect();
          String sql = "SELECT BALANCE FROM customer WHERE USERNAME = ?";
          
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1,uid);
             ResultSet rs=ps.executeQuery();
              
              double bal = rs.getDouble("balance");
              if(bal < 300 || bal < fare)
              {
                  answer = false;
              }
              
              
              
              
      }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return answer;
    }
    
  
    public static String FindNearestDriverWithHighestRating(String Cust_Loc_Description)
    {
        String answer = null;
        Integer curr_distance = Integer.MAX_VALUE;
        int curr_rating = -1;
        int cust_loc = getLocationNumber(Cust_Loc_Description);
        
        
      try
      {
           Connection con= dbm2.dbconnect();
          String sql = "SELECT DRIVERID,RATING,LOCATION FROM driver WHERE ISBUSY = ?";
      
          PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1,0);
              ResultSet rs=ps.executeQuery();
              
              while(rs.next())
              {
                   int driver_loc = rs.getInt("LOCATION");
                   String driver_loc_description = getLocationDescription(driver_loc);
                   if(Distance(Cust_Loc_Description,driver_loc_description) < curr_distance)
                   {
                       answer = rs.getString("DRIVERID");
                       curr_rating = rs.getInt("RATING");
                       curr_distance = Distance(Cust_Loc_Description,driver_loc_description);
                   } 
              }
      }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
      
     
      try
      {
           Connection conn = dbm2.dbconnect();
    

          String sql = "SELECT DRIVERID,RATING,LOCATION FROM driver WHERE ISBUSY = ?";
      
            PreparedStatement ps1 =conn.prepareStatement(sql);
            ps1.setInt(1,0);
              ResultSet rs1=ps1.executeQuery();
              
              while(rs1.next())
              {
                  
                  int driver_loc = rs1.getInt("LOCATION");
                   String driver_loc_description = getLocationDescription(driver_loc);
                   
                   if(Distance(Cust_Loc_Description,driver_loc_description) == curr_distance)
                   {
                       int driver_rating = rs1.getInt("RATING");
                       
                       if(driver_rating > curr_rating)
                       {
                            answer = rs1.getString("DRIVERID");
                           curr_rating = rs1.getInt("RATING");
                           
                       }
                   }
                       
                   
                   
              }
      }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
      
      
      
      return answer;
    }
    
    public static int CalculateTripEndtime(String pickup_loc,String drop_loc)
    {
        return currenttime + CalculateTripDuration(pickup_loc,drop_loc);
    }
    public static int CalculateTripDuration(String pickup_loc,String drop_loc)
    {
        return Distance(pickup_loc,drop_loc);
    }
    public static String AddBooking(int Customer_Location,int Drop_Location,String userid,String driverid)      
    {
        
        String answer = null;
        

      try
      {
            Connection con = dbm3.dbconnect();
           String query="insert into booking values(?,?,?,?,?,?,?)";
         PreparedStatement ps=con.prepareStatement(query);
         String referencenumber=String.valueOf(new Date().getTime());
          answer = String.valueOf(referencenumber);
          ps.setString(1,referencenumber);
          ps.setString(2,userid);
          ps.setInt(3,Integer.parseInt(driverid));
          ps.setString(4,String.valueOf(Customer_Location));
          ps.setString(5,String.valueOf(Drop_Location));
          ps.setInt(6,currenttime);
          ps.setInt(7,CalculateTripEndtime(getLocationDescription(Customer_Location),getLocationDescription(Drop_Location)));      
          ps.execute();
           UpdateDriverStatusStartTrip(driverid);
             
                   
              
      }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
      return answer;
      
    }
    
    
    public static void UpdateDriverStatusStartTrip(String driverid)
    {
       
      
      try
      {
                    
                     Connection con= dbm2.dbconnect();
                 String sqlQuery = "UPDATE driver SET ISBUSY = ? WHERE DRIVERID = ?";
                PreparedStatement ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,1);
                ps.setInt(2,Integer.parseInt(driverid));
                ps.executeUpdate();
         
      }
        catch(Exception e){
            System.out.println( e.getMessage());
        }
      
    }
    
    public static void UpdateDriverStatusEndTrip(String driverid)
    {
        try
        {
              Connection con= dbm2.dbconnect();
                 String sqlQuery = "UPDATE driver SET ISBUSY = ? WHERE DRIVERID = ?";
                PreparedStatement ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,0);
                ps.setInt(2,Integer.parseInt(driverid));
                ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println( e.getMessage());
        }
    }
    
    public static void Randomize()
    {
        
        ArrayList<Integer> freedriverlist = new ArrayList<Integer>();
        
        
        try
        {
            Connection conn= dbm2.dbconnect();
             String sql = "SELECT DRIVERID FROM driver WHERE ISBUSY = ?";
      
            PreparedStatement ps1 =conn.prepareStatement(sql);
            ps1.setInt(1,0);
              ResultSet rs1=ps1.executeQuery();
              
              while(rs1.next())
              {
                  int driver_id = rs1.getInt("DRIVERID");
                  freedriverlist.add(driver_id);
                  
              }
            
            
        }
         catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        int numberofdrivers = freedriverlist.size();
        
        if(numberofdrivers == 0 )
        {
            return ;
        }
        int delta = 16/numberofdrivers;
        
        int new_location = 1;
        
        for(int i = 0; i < freedriverlist.size();i++)
        {
            try
            {
                 Connection con= dbm2.dbconnect();
                 String sqlQuery = "UPDATE driver SET LOCATION = ? WHERE DRIVERID = ?";
                PreparedStatement ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,new_location);
                ps.setInt(2,freedriverlist.get(i));
                ps.executeUpdate();
            }
            catch(Exception e){
            System.out.println(e.getMessage());
        }
            new_location += delta;
        }

    }
    public static void ChangeUserBalance(String userid,int Fare)
    {
        int userbalance  = 0;
         try
        {
            Connection conn= dbm.dbconnect();
             String sql = "SELECT BALANCE FROM customer WHERE USERNAME =?";
      
            PreparedStatement ps1 =conn.prepareStatement(sql);
            ps1.setString(1,userid);
              ResultSet rs1=ps1.executeQuery();
            userbalance  = rs1.getInt("BALANCE");
        }
         catch(Exception e){
            System.out.println(e.getMessage());
        }
         
         
         int newuserbalance = userbalance - Fare;
         
           try
        {
             Connection con= dbm.dbconnect();
                 String sqlQuery = "UPDATE customer SET BALANCE = ? WHERE USERNAME = ?";
                PreparedStatement ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,newuserbalance);
                ps.setInt(2,Integer.parseInt(userid));
                ps.executeUpdate();
        }
         catch(Exception e){
            System.out.println(e.getMessage());
        }
         
    }
    
    public static void changetime(int start_time,int end_time)
    {
        int current_time = start_time;
        
        while(current_time <= end_time)
        {
            current_time++;
        }
    }
    
}
