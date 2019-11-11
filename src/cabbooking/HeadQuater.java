/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.regex.Pattern;
import javax.swing.*;
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
                  break;
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
    try { if (ps1 != null) ps1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
;
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
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
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
      ChangeBookingStatus(userid);
         
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
          
           try
           {
           EndTrip(toend.get(i));           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }           
       }
   }
   
   public static void removedriver(int driverid)
   {
        Connection conn=dbm2.dbconnect();
     // String query="DELETE FROM driver WHERE DRIVERID= ? ";
     PreparedStatement ps1=null;
      try{
     String query="DELETE FROM driver WHERE DRIVERID= ? ";
     ps1=conn.prepareStatement(query);
      ps1.setInt(1,driverid);
      ps1.executeUpdate();
      }
      catch(java.sql.SQLException e){ }
      finally{
         
         try { if (ps1 != null) ps1.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
      }
   }
   
   public static void adddriver(Driver ob)
   {
       
              Connection con = null;
        PreparedStatement ps = null;
        
      try
      {
            con = dbm2.dbconnect();
           String query="insert into driver values(?,?,?,?,?,?,?,?)";
          ps=con.prepareStatement(query);
          ps.setString(1,ob.getDriverName());
          ps.setInt(2,ob.getDriverId());
          ps.setString(3,ob.getPhoneNumber());
          ps.setInt(4,3);
          ps.setString(5,ob.getVehicleNumber());
          ps.setString(6,ob.getVehicleName());
          ps.setInt(7,ob.getLocation());      
          ps.setInt(8,0);
          ps.execute();
      }
        catch(SQLException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
             finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
   }
   
   public static Driver retriveDriverData(int driverid)
   {
       
       
         Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Driver ob = null;
        
          try
        {
            connect= dbm2.dbconnect();
             String sql = "SELECT * FROM DRIVER WHERE DRIVERID = ?";
             ps=connect.prepareStatement(sql);
             ps.setInt(1,driverid);
             rs=ps.executeQuery(); 
             ob = new Driver(rs.getString("DRIVERNAME"),driverid,rs.getString("PHONENUMBER"),rs.getInt("RATING"),rs.getString("VEHICLENUMBER"),rs.getString("VEHICLENAME"),rs.getInt("LOCATION"),rs.getInt("ISBUSY"));
        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
            finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (connect != null) connect.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
       
       
          return ob;
   }
   
   public static boolean canEditProfile()
   {
       boolean answer = true;
       return answer;
   }
   public static void editprofile()
   {
       
   }
   public static boolean verify_email(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean verify_name(String name) {
        String Regex = "^[\\p{L} .'-]+$";
        Pattern pat = Pattern.compile(Regex); 
        if (name == null) 
            return false;
        return pat.matcher(name).matches();
    }
    public static boolean verify_phonenumber(String phonenumber) {
        String Regex = "^[6-9]\\d{9}$";
        Pattern pat = Pattern.compile(Regex); 
        if (phonenumber == null) 
            return false;
        return pat.matcher(phonenumber).matches();
    }
   public static boolean canSignUp(String name,Date dob,String emailid,String userid,String password,String phoneNumber,String address)
   {
      
       
       if("Enter Name".equals(name))
       {

           JOptionPane.showMessageDialog(null, "Enter Valid Name");
           return false;
       }
        if(verify_name(name) == false)
         {  
             JOptionPane.showMessageDialog(null, "Enter Valid Name");
           return false;
         }
       
       Date d1 = null;
       Date presentdate = new Date();
       
       if(dob == d1)
       {
           JOptionPane.showMessageDialog(null, "Enter Valid Date Of Birth");
           return false;
       }
       
        try 
        {
                if(presentdate.before(dob))
               {

               JOptionPane.showMessageDialog(null, "Enter Valid Date Of Birth");
               return false;
               }
         
        }
        catch(HeadlessException e)
        {

                JOptionPane.showMessageDialog(null, "Enter Valid Date Of Birth");
                return false;
        }
        
         if("Enter Email ID".equals(emailid))
       {
           JOptionPane.showMessageDialog(null, "Enter Valid Email ID");
           return false;
       }
         if(verify_email(emailid) == false)
         {
             JOptionPane.showMessageDialog(null, "Enter Valid Email ID");
           return false;
         }
         
         if("Enter User ID".equals(userid))
         {
             JOptionPane.showMessageDialog(null, "Enter a Valid User Name");
             return false;
         }
         
         if(doesUserIdExists(userid))
         {
              JOptionPane.showMessageDialog(null, "User ID Already in Use");
             return false;
         }
         
         if(password.length() == 0)
         {
             JOptionPane.showMessageDialog(null, "Enter Valid Password");
             return false;
         }
         
         if("Enter Phone Number".equals(phoneNumber))
         {
             JOptionPane.showMessageDialog(null, "Enter Phone Number");
             return false;
         }
         if(verify_phonenumber(phoneNumber) == false)
         {
             JOptionPane.showMessageDialog(null, "Enter a Valid Phone Number");
           return false;
         }
         
         if("Enter Address".equals(address))
         {
             JOptionPane.showMessageDialog(null, "Enter Valid Address");
             return false;
         }
         
         
       
       return true;
   }
   
   public static boolean doesUserIdExists(String userid)
   {
       boolean answer = false;
       
       Connection conn = null;
       PreparedStatement ps1 = null;
       ResultSet rs1 = null;
         try
        {
            conn= dbm.dbconnect();
             String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ?";
             ps1 =conn.prepareStatement(sql);
             ps1.setString(1,userid);
             rs1=ps1.executeQuery();
             
            while(rs1.next())
            {
                answer = true;
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
       
       return answer;
       
   }

    /**
     *
     * @param ob
     */
    public static void AddCustomer(Customer ob)
   {
             Connection con = null;
        PreparedStatement ps = null;
        
      try
      {
            con = dbm.dbconnect();
           String query="insert into CUSTOMER values(?,?,?,?,?,?,?,?,?)";
          ps=con.prepareStatement(query);
          ps.setString(1,ob.getName());
          ps.setString(2,ob.getAddress());
          ps.setString(3,ob.getEmail());
          ps.setString(4, ob.getUsername());
          ps.setString(5,ob.getPassword());
          ps.setInt(6,ob.getBalance());
          ps.setString(7,ob.getDob());
         ps.setInt(8,ob.getIsBusy());
          ps.setString(9,ob.getPhonenumber());
         
          
          
          
          ps.execute();
      }
        catch(SQLException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
             finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
      
   }
   
   public static Customer retriveCustomerData(String userid)
   {
       Customer ob = null;
       
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
 
        
          try
        {
            connect= dbm.dbconnect();
             String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ?";
             ps=connect.prepareStatement(sql);
             ps.setString(1,userid);
             rs=ps.executeQuery(); 
             
             ob = new Customer(rs.getString("NAME"),rs.getString("ADDRESS"),rs.getString("EMAIL"),userid,rs.getString("PASSWORD"),rs.getInt("BALANCE"),rs.getString("DATE OF BIRTH"),rs.getInt("ISBUSY"),rs.getString("PHONENUMBER"));
            
 
        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
            finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (connect != null) connect.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
       
       return ob;
   }
   
   public static void updateCustomerData(Customer ob)
   {
        Connection con = null;
      PreparedStatement ps = null;
      
      try
      {
     con= dbm.dbconnect();
     System.out.println(ob.toString());
     String sql = "UPDATE customer SET BALANCE =? , ISBUSY =? , EMAIL =? , PASSWORD =? , PHONENUMBER =? WHERE USERNAME =?";
          
       ps =con.prepareStatement(sql);
           
       ps.setInt(1, ob.getBalance());
       ps.setInt(2,ob.getIsBusy());
       ps.setString(3,ob.getEmail());
       ps.setString(4,ob.getPassword());
       ps.setString(5,ob.getPhonenumber());
       ps.setString(6,ob.getUsername());

 
             ps.executeUpdate();
      }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
      finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    
    
}
      
      
   }
   
   public static boolean isCustomerPasswordCorrect(String userid,String password)
   {
       Customer ob = retriveCustomerData(userid);
       return ob.getPassword().equals(password);
   }
   public static boolean isAdminUser(String userid)
   {
       return userid.equals("Radhesh")||userid.equals("Amogh")||userid.equals("Simran")||userid.equals("Jalaj");
   }
    public static boolean isAdminPasswordCorrect(String userid,String password)
   {
       if(userid.equals("Radhesh")||userid.equals("Amogh")||userid.equals("Simran")||userid.equals("Jalaj"))
       {
           if(password.equals("admin"))
           {
               return true;
           }
       }
       
       return false;
   }
   
   
   
   public static void ChangeBookingStatus(String userid)
   {
       Connection con = null ; 
       PreparedStatement ps = null; 
       try
        {
              con= dbm3.dbconnect();
                 String sqlQuery = "UPDATE booking SET ISTRIPENDED = ? WHERE USERNAME = ?";
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
   public static void AddBooking(Booking ob)
   {
             Connection con = null;
        PreparedStatement ps = null;
        
      try
      {
            con = dbm3.dbconnect();
           String query="insert into BOOKING values(?,?,?,?,?,?,?,?)";
          ps=con.prepareStatement(query);
          ps.setString(1,ob.getReferenceNumber());
          ps.setString(2,ob.getUserName());
          ps.setInt(3,ob.getDriverId());
          ps.setString(4, ob.getPickUpLocation());
          ps.setString(5,ob.getDropLocation());
          ps.setString(6,ob.getTripStartTime());
          ps.setString(7,ob.getTripEndTime());
         ps.setInt(8,ob.getIsTripEnded());
         
         
          
          
          
          ps.execute();
      }
        catch(SQLException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
             finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
      
   }
   
   public static Booking retriveBookingData(String referno)
   {
       Booking ob = null;
       
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
 
        
          try
        {
            connect= dbm3.dbconnect();
             String sql = "SELECT * FROM BOOKING WHERE REFERENCENUMBER = ?";
             ps=connect.prepareStatement(sql);
             ps.setString(1,referno);
             rs=ps.executeQuery(); 
             
             ob = new Booking(referno,rs.getString("USERNAME"),rs.getInt("DRIVERID"),rs.getString("PICKUPLOCATION"),rs.getString("DROPLOCATION"),rs.getString("TRIPSTARTTIME"),rs.getString("TRIPENDTIME"),rs.getInt("ISTRIPENDED"));
            
 
        }
         catch(SQLException e){
            System.out.println(e.getMessage());
        }
            finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (connect != null) connect.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
       
       return ob;
   }
   
    /**
     *
     * @param ob
     */
    public static void updateBookingData(Booking ob)
   {
        Connection con = null;
      PreparedStatement ps = null;
      
      try
      {
     con= dbm3.dbconnect();
     System.out.println(ob.toString());
     String sql = "UPDATE booking SET ISTRIPENDED =? WHERE REFERENCENUMBER =?";
          
       ps =con.prepareStatement(sql);
           
       ps.setInt(1, ob.getIsTripEnded());
       ps.setString(2,ob.getReferenceNumber());
      

 
             ps.executeUpdate();
      }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
      finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    
    
}
      
      
   }
    public static void updateDriverData(Driver ob)
   {
        Connection con = null;
      PreparedStatement ps = null;
      
      try
      {
     con= dbm2.dbconnect();
     System.out.println(ob.toString());
     String sql = "UPDATE driver SET ISBUSY =? , PHONENUMBER =? , LOCATION =? WHERE DRIVERID =?";
          
       ps =con.prepareStatement(sql);
           
       ps.setInt(1, ob.getIsBusy());
       ps.setString(2,ob.getPhoneNumber());
       ps.setInt(3,ob.getLocation());
       ps.setInt(4,ob.getDriverId());
       

 
             ps.executeUpdate();
      }
        catch(SQLException e){
            System.out.println("yoyo"+e.getMessage());
        }
      finally {
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (con != null) con.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    
    
}
      
      
   }
   
   
   
}
