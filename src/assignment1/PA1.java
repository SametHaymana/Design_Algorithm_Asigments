/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ucarr
 */
public class PA1 {

    /**
     * @param args the command line arguments
     */
    
    private LinkedList list = new LinkedList(); 
    private Map<String,Long> statusInformations ;
    
    private TimeCounter timer;
    
    public PA1() 
    { 
       
        this.timer = new TimeCounter();
        this.statusInformations = new HashMap<String,Long>();
        
        
        this.timer.startTimer();
        // Insert the values 
        try{
            Scanner scanner = new Scanner(new File("1Mint.txt"));
            
            while(scanner.hasNextInt()){
                LinkedList.insert(list, scanner.nextInt());
            }
            scanner.close();
        }catch (IOException e) {
            System.out.println("error!!!");
        }
        
        this.timer.stopTimer();
        this.statusInformations.put("built_time",this.timer.getElepsedTime());
        
        //System.out.println("The integer list structure is built in "+x+" milliseconds.");
        
        
        this.timer.startTimer();
        LinkedList.insertAtHead(list, 0);
        this.timer.stopTimer();
        this.statusInformations.put("insert_head",this.timer.getElepsedTime());
        //System.out.println("An integer is inserted into the first index of the integer list in "+y+" milliseconds.");
        
        
        this.timer.startTimer();
        LinkedList.InsertAtPos(list, 900000, 0);
        this.timer.stopTimer();
        this.statusInformations.put("insert_nineht",this.timer.getElepsedTime());
        //System.out.println("An integer is inserted into the 900,000th index of the integer list in "+z+" milliseconds.");
        
        this.timer.startTimer();
        LinkedList.readAtPos(list,900000 ); 
        int nineht =  LinkedList.readAtPos(list, 900000).data; 
        this.timer.stopTimer();
        this.statusInformations.put("d_value",(long)nineht);
        this.statusInformations.put("read_nineht",this.timer.getElepsedTime()); 
        //System.out.println("An integer, which is the_value, is read from the index 900,000 of the integer list in "+w+" milliseconds.");
        
        this.timer.startTimer();
        LinkedList.readAtPos(list, 9);     
        int nine =  LinkedList.readAtPos(list, 9).data;
        this.timer.stopTimer();
        this.statusInformations.put("e_value",(long)nine);
        this.statusInformations.put("read_nine",this.timer.getElepsedTime()); 
        //System.out.println("An integer, which is the_value, is read from the index 9 of the integer list in "+h+" milliseconds.");
     
    }
    
     public void printStatus(){
        System.out.println("The integer list structure is built in "+ this.statusInformations.get("built_time") +" milliseconds.");
        System.out.println("An integer is inserted into the first index of the integer list in "+this.statusInformations.get("insert_head")+" milliseconds.");
        System.out.println("An integer is inserted into the 900,000th index of the integer list in "+this.statusInformations.get("insert_nineht")+" milliseconds.");
        System.out.println("An integer, which is "+this.statusInformations.get("d_value")+" , is read from the index 900,000 of the integer list in "+this.statusInformations.get("read_nineht")+" milliseconds.");
        System.out.println("An integer, which is "+this.statusInformations.get("e_value")+" , is read from the index 9 of the integer list in "+this.statusInformations.get("read_nine")+" milliseconds.");
    }
}
