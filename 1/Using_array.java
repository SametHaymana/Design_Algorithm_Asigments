import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



/*
 * 
 *      
 * @author Tomahawk
 * 
 * 
 */
public class Using_array {
    
    private int[] array ;
    private Map<String,Long> statusInformations ;

    private File file;
    private int index;
    private TimeCounter timer;

    /**
     * @param filePointer
     * @param length
     */
    public Using_array(File filePointer, int length){
        

        // Init
        this.file = filePointer;
        this.timer = new TimeCounter();
        this.statusInformations = new HashMap<String,Long>();
        this.index = 0;
        this.array = new int[length];
 

    }


    /*
     * Function to add new integer to end of the array
     * 
    */
    private void append(int i){
        this.array[this.index] = i;
        this.index ++;
    }




    /*
     * 
     * 
     *  Function read file line by line and same reason calculate elepsed time 
     *  for status reporting and it main functionality is adding integer to end
     *  of the array.
     * 
     *  
     */
    public void read() throws FileNotFoundException{
        Scanner reader = new Scanner(this.file);

        // A different time counter for 
        TimeCounter timer2 = new TimeCounter();
        // Start timer
        timer2.startTimer();
        
        
        while(reader.hasNextLine()){
            if(this.index == 0){
                // get time elepsed
                this.timer.startTimer();
                this.append(Integer.parseInt(reader.nextLine()));
                this.timer.stopTimer();

                this.statusInformations.put("b",this.timer.getElepsedTime());

            }else if(this.index == 9){
                // get time elepsed
                this.timer.startTimer();
                int number = Integer.parseInt(reader.nextLine());
                this.append(number);
                this.timer.stopTimer();

                this.statusInformations.put("e",this.timer.getElepsedTime());
                this.statusInformations.put("e_value",(long)number);

            }else if(this.index == 900000){
                // get time elepsed
                this.timer.startTimer();
                int number = Integer.parseInt(reader.nextLine());
                this.append(number);
                this.timer.stopTimer();

                this.statusInformations.put("d",this.timer.getElepsedTime());
                this.statusInformations.put("d_value",(long)number);

            }else if(this.index == this.array.length-1){
                // for the last index
                this.timer.startTimer();
                this.append(Integer.parseInt(reader.nextLine()));
                this.timer.stopTimer();

                this.statusInformations.put("c",this.timer.getElepsedTime());
            }else{
                this.append(Integer.parseInt(reader.nextLine()));

            }

        }
        timer2.stopTimer();
        this.statusInformations.put("a",timer2.getElepsedTime());

        reader.close();
    }



    public void printStatus(){
        System.out.println("The integer list structure is built in "+ this.statusInformations.get("a") +" milliseconds.");
        System.out.println("An integer is inserted into the first index of the integer list in "+this.statusInformations.get("b")+" milliseconds.");
        System.out.println("An integer is inserted into the 900,000th index of the integer list in "+this.statusInformations.get("c")+" milliseconds.");
        System.out.println("An integer, which is "+this.statusInformations.get("d_value")+" , is read from the index 900,000 of the integer list in "+this.statusInformations.get("d")+" milliseconds.");
        System.out.println("An integer, which is "+this.statusInformations.get("e_value")+" , is read from the index 9 of the integer list in "+this.statusInformations.get("e")+" milliseconds.");
    }
    

  
    


}
