/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;



/*
 *  Class to calculate elepsed time in any process.
 *  
 *  @author 
 *      Abdulsamet Haymana
 * 
 */
public class TimeCounter{
    
    private long elepsedTime;
    private LocalTime startTime;
    

    public TimeCounter (){
        this.elepsedTime = 0;
    }


    /*
    *  Seting "startTime" property to current time for observe
    *  the time change is taken as the start time.
    * 
    */
    void startTimer(){
        
        this.startTime = LocalTime.now();
    }



    /*
    * 
    *  Calculate elepsedTime with different between "startTime" onbject.
    *  
    *  @return long This return elepsed time.
    * 
    * 
    */
    long stopTimer(){
        long elepsedTime;

        // get cuurent time of when process done
        LocalTime currentTime = LocalTime.now();

        // get differance of process start and now as millisecod
        elepsedTime = this.startTime.until(currentTime, ChronoUnit.MICROS);

        // store also class property
        this.elepsedTime = elepsedTime;

        return elepsedTime;

    }


    long getElepsedTime(){
        return this.elepsedTime;
    }

}