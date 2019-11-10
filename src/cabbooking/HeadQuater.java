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
import java.util.*; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
/**
 *
 * @author Radhesh
 */



public class HeadQuater 
{

  
   
    
    
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
    
    public static boolean isUserFree(String userid)
    {
        boolean answer = true;
        
        Connection conn = null ;
        PreparedStatement ps = null;
        ResultSet rs1 = null;
        
        try
      {
       conn= dbm.dbconnect();
          String sql = "SELECT ISBUSY FROM customer WHERE USERNAME = ?";
          
             ps =conn.prepareStatement(sql);
            ps.setString(1,userid);
             rs1=ps.executeQuery();
              
              int status = rs1.getInt("ISBUSY");
              

            
              if(status == 1)
                  
              {
                  answer = false;
              }
              
              
              
      }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
           finally {
    try { if (rs1 != null) rs1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
      
        
        
        
        return answer;
        
        
    }
    public static boolean isCabAvailable(String userid)
    {
        
        boolean answer = false;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
      try
      {
          
              
      con= dbm2.dbconnect();
      
      String sql = "SELECT * FROM driver WHERE ISBUSY=? ";
            ps =con.prepareStatement(sql);
            ps.setInt(1,0);
              rs=ps.executeQuery();
              
              while(rs.next())
              {
        
                  answer = true;    
              }
              
            
      }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
      finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
      
        
      
         if(answer == true)
         {
            
        answer = isUserFree(userid);
         }
        
        return answer;
    }
    
    public static boolean CanBookCab(String uid,int fare)
    {
        boolean answer = true;
       
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      try
      {
     con= dbm.dbconnect();
          String sql = "SELECT BALANCE FROM customer WHERE USERNAME = ?";
          
       ps =con.prepareStatement(sql);
            ps.setString(1,uid);
            rs=ps.executeQuery();
              
              double bal = rs.getDouble("balance");
              if(bal < 300 || bal < fare)
              {
                  answer = false;
              }
              
              
              
              
      }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
      finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
        
        return answer;
    }
    
  
    @SuppressWarnings("empty-statement")
    public static String FindNearestDriverWithHighestRating(String Cust_Loc_Description)
    {
        String answer = null;
        Integer curr_distance = Integer.MAX_VALUE;
        int curr_rating = -1;
        int cust_loc = getLocationNumber(Cust_Loc_Description);
        
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        
      try
      {
          con= dbm2.dbconnect();
          String sql = "SELECT DRIVERID,RATING,LOCATION FROM driver WHERE ISBUSY = ?";
      
           ps =con.prepareStatement(sql);
            ps.setInt(1,0);
              rs=ps.executeQuery();
              
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
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
;
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
;
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
;
}
      
      
        Connection conn = null;
        PreparedStatement ps1 = null;
        ResultSet rs1= null;
        
      try
      {
           conn = dbm2.dbconnect();
    

          String sql = "SELECT DRIVERID,RATING,LOCATION FROM driver WHERE ISBUSY = ?";
      
             ps1 =conn.prepareStatement(sql);
            ps1.setInt(1,0);
               rs1=ps1.executeQuery();
              
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
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
         finally {
    try { if (rs1 != null) rs1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps1 != null) ps1.close(); } catch (Exception e) {System.out.println(e.getMessage());};
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
     
      
      
      
      
      return answer;
    }
    
    public static String CalculateTripEndtime(String pickup_loc,String drop_loc)
    {

        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
     LocalDateTime answer = LocalDateTime.now().plusMinutes(CalculateTripDuration(pickup_loc,drop_loc));
     
     return dtf.format(answer);
        
    }
    public static int CalculateTripDuration(String pickup_loc,String drop_loc)
    {
        return Distance(pickup_loc,drop_loc);
    }
    @SuppressWarnings("empty-statement")
    public static String AddBooking(int Customer_Location,int Drop_Location,String userid,String driverid)      
    {
        
        String answer = null;
        
        Connection con = null;
        PreparedStatement ps = null;
        
      try
      {
            con = dbm3.dbconnect();
           String query="insert into booking values(?,?,?,?,?,?,?,?)";
          ps=con.prepareStatement(query);
         String referencenumber=String.valueOf(new Date().getTime());
          answer = String.valueOf(referencenumber);
          ps.setString(1,referencenumber);
          ps.setString(2,userid);
          ps.setInt(3,Integer.parseInt(driverid));
          ps.setString(4,String.valueOf(Customer_Location));
          ps.setString(5,String.valueOf(Drop_Location));
          ps.setString(6,HeadQuater.GetCurrentTime());
          ps.setString(7,CalculateTripEndtime(getLocationDescription(Customer_Location),getLocationDescription(Drop_Location)));      
          ps.setInt(8,0);
          ps.execute();
           UpdateDriverStatusStartTrip(driverid);
           UpdateCustomerStatusStartTrip(userid);
                   
              
      }
        catch(SQLException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
             finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
;
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
;
}
      
      
      return answer;
      
    }
    
    
    public static void UpdateDriverStatusStartTrip(String driverid)
    {
       
       Connection con = null;
        PreparedStatement ps = null ;
        
      try
      {
                    
                    con= dbm2.dbconnect();
                 String sqlQuery = "UPDATE driver SET ISBUSY = ? WHERE DRIVERID = ?";
                 ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,1);
                ps.setInt(2,Integer.parseInt(driverid));
                ps.executeUpdate();
         
      }
        catch(SQLException | NumberFormatException e){
            System.out.println( e.getMessage());
        }
           finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
      
    }
    
    public static void UpdateDriverStatusEndTrip(String driverid,int location)
    {
        Connection con = null;
        PreparedStatement ps = null ;
        
        try
        {
             con= dbm2.dbconnect();
                 String sqlQuery = "UPDATE driver SET ISBUSY = ? , LOCATION = ? WHERE DRIVERID = ?";
                ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,0);
                 ps.setInt(2, location);
                ps.setInt(3,Integer.parseInt(driverid));
                ps.executeUpdate();
        }
        catch(SQLException | NumberFormatException e){
            System.out.println( e.getMessage());
        }
          finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
        
    }
    
    public static void Randomize()
    {
        
        ArrayList<Integer> freedriverlist = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        
        try
        {
             conn= dbm2.dbconnect();
             String sql = "SELECT DRIVERID FROM driver WHERE ISBUSY = ?";
      
           ps1 =conn.prepareStatement(sql);
            ps1.setInt(1,0);
               rs1=ps1.executeQuery();
              
              while(rs1.next())
              {
                  int driver_id = rs1.getInt("DRIVERID");
                  freedriverlist.add(driver_id);
                  
              }
            
            
        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
         
        finally {
    try { if (rs1 != null) rs1.close(); }
    catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps1 != null) ps1.close(); } 
    catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } 
    catch (SQLException e) {System.out.println(e.getMessage());}
}
        
        int numberofdrivers = freedriverlist.size();
        
        if(numberofdrivers == 0 )
        {
            return ;
        }
        int delta = 16/numberofdrivers;
        
        int new_location = 1;
        
        
        
        for (Integer freedriverlist1 : freedriverlist) 
        {
             Connection con = null;
               PreparedStatement ps = null;
            try {
                con= dbm2.dbconnect();
                String sqlQuery = "UPDATE driver SET LOCATION = ? WHERE DRIVERID = ?";
                 ps =con.prepareStatement(sqlQuery);
                ps.setInt(1,new_location);
                ps.setInt(2, freedriverlist1);
                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
               finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
            
            new_location += delta;
        }

    }
    public static void ChangeUserBalance(String userid,int Fare)
    {
        
        int userbalance  = 0;
        Connection conn = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        
         try
        {
            conn= dbm.dbconnect();
             String sql = "SELECT BALANCE FROM customer WHERE USERNAME =?";
      
             ps1 =conn.prepareStatement(sql);
            ps1.setString(1,userid);
              rs1=ps1.executeQuery();
            userbalance  = rs1.getInt("BALANCE");
        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
            finally {
    try { if (rs1 != null) rs1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps1 != null) ps1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
         
         
         int newuserbalance = userbalance - Fare;
         System.out.println(userbalance);
         System.out.println(Fare);
         System.out.println(newuserbalance);
         Connection con = null;
        PreparedStatement ps = null;   
           try
        {
                 con= dbm.dbconnect();
                 String sqlQuery = "UPDATE customer SET BALANCE = ? WHERE USERNAME = ?";
                 ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,newuserbalance);
                ps.setString(2,(userid));
                ps.executeUpdate();
        }
         catch(SQLException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
                finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
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
    
   public static void UpdateCustomerStatusStartTrip(String userid)
   {
       Connection con = null;
       PreparedStatement ps = null; 
       try
        {
               con= dbm.dbconnect();
                 String sqlQuery = "UPDATE customer SET ISBUSY = ? WHERE USERNAME = ?";
                 ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,1);
                ps.setInt(2,Integer.parseInt(userid));
                ps.executeUpdate();
        }
        catch(SQLException | NumberFormatException e){
            System.out.println( e.getMessage());
        }
               finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
       
   }
    
   public static void UpdateCustomerStatusEndTrip(String userid)
   {
       Connection con = null ; 
       PreparedStatement ps = null; 
       try
        {
              con= dbm.dbconnect();
                 String sqlQuery = "UPDATE customer SET ISBUSY = ? WHERE USERNAME = ?";
                ps =con.prepareStatement(sqlQuery);
                 ps.setInt(1,0);
                ps.setInt(2,Integer.parseInt(userid));
                ps.executeUpdate();
        }
        catch(SQLException | NumberFormatException e){
            System.out.println( e.getMessage());
        }
             finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
       
   }
   
   
   public static String GetCurrentTime()
   {
       
       
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
     LocalDateTime now = LocalDateTime.now();
     
     return dtf.format(now);
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
   // Date date = new Date();  
   }
   public static int Comparetime(String s1,String s2)
   {
       return s1.compareTo(s2);
   }
   
   
   public static void EndTrip(String referencenumber)
   {
          Connection conn = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
           String userid = null;
         String driverid = null;
           String pickuploc =null;
           String droploc = null;
         try
        {
            conn= dbm3.dbconnect();
             String sql = "SELECT * FROM booking WHERE REFERENCENUMBER =?";
      
             ps1 =conn.prepareStatement(sql);
            ps1.setString(1,referencenumber);
              rs1=ps1.executeQuery();
              driverid = String.valueOf(rs1.getInt("DRIVERID"));
              userid = rs1.getString("USERNAME");
              pickuploc = HeadQuater.getLocationDescription(rs1.getInt("PICKUPLOCATION"));
              droploc = HeadQuater.getLocationDescription(rs1.getInt("DROPLOCATION"));

        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
            finally {
    try { if (rs1 != null) rs1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps1 != null) ps1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
         
         
         
         
         
      UpdateCustomerStatusEndTrip(userid);
      UpdateDriverStatusEndTrip(driverid,getLocationNumber(droploc));
      ChangeUserBalance(userid,HeadQuater.CalculateFare(pickuploc,droploc));
      
         
   }
   
   
   public static void TimeChecker()
   {
       
       Connection conn = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
       
        String currenttime = GetCurrentTime();
        
        ArrayList<String> toend = new ArrayList();
        
        
           try
        {
            conn= dbm3.dbconnect();
             String sql = "SELECT * FROM booking WHERE ISTRIPENDED = ?";
             ps1 =conn.prepareStatement(sql);
             ps1.setInt(1,0);
             rs1=ps1.executeQuery();
             
             while(rs1.next())
             {
                 String tripendtime = rs1.getString("TRIPENDTIME");
                 if(Comparetime(currenttime,tripendtime)>=0)
                 {
                     toend.add(rs1.getString("REFERENCENUMBER"));
                 }
                 
             }
             
        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
            finally {
    try { if (rs1 != null) rs1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps1 != null) ps1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
       
       
       
       for(int i = 0; i < toend.size();i++)
       {
           EndTrip(toend.get(i));
       }
       
       
   }
   
   
}
