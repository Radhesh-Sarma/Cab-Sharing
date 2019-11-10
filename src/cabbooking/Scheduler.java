/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author radhesh
 */
public class Scheduler extends TimerTask{
    public void run()
    {
        
        try
        {
            HeadQuater.TimeChecker();
        }
        catch(Exception e)
                {
                    
                    System.out.println("In Scheduler " + e.getMessage());
                }
    }
    
}
