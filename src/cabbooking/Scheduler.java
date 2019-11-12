/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;
import java.util.TimerTask;
import java.util.Date;
/**
 *
 * @author radhesh
 */
public class Scheduler extends TimerTask{
    @Override
    public void run()
    {
        
        try
        {
            System.out.println("Timer task Executed " + new Date());
            HeadQuater.TimeChecker();
        }
        catch(Exception e)
                {
                    
                    System.out.println("In Scheduler " + e.getMessage());
                }
    }
    
}
