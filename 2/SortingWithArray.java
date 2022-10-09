
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;





/*
 *  The goal of this class read 1 million line integer
 *  and sort it to an array.
 * 
 *  @author
 *      Abdulsamet Haymana
 * 
 * 
 */
public class SortingWithArray {
    
    public int ONEMILLION = 1000000;
    public int FIFTYONEMILLION = 50000000;
    
    public int arrayİndex;

    private int sortedArray[];
    private File file;
    private TimeCounter timer;

    public Map<String,Long> statusInformations ;



    /*
     * 
     *  Open file in constructor time.
     *  throws fileNotFound if file 
     *  not in "fileName" path.
     * 
     */
    SortingWithArray(String fileName) throws FileNotFoundException{
        // init Timer Class
        this.timer = new TimeCounter();

        // init Hasmap
        this.statusInformations = new HashMap<String,Long>();

        // open file
        this.file = new File(fileName);

        // Set start index to 0
        this.arrayİndex = 0;

        this.timer.startTimer();
        
        // Init array for 1 million slot storage
        if(fileName == "50Mint.txt")
            this.sortedArray = new int[this.FIFTYONEMILLION];
        else
            this.sortedArray = new int[this.ONEMILLION];
            

        this.timer.stopTimer();

        // Store int array build time in hashmap
        this.statusInformations.put("a",this.timer.getElepsedTime());
    
        
    
        

    }




    /*
     * 
     *  Concat two array with use copy them in a big array
     * 
     * 
     */
    private int[] concatTwoArray(int[] array1, int[] array2){
        int[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }


    /*
     * 
     * It is used to place the number in the specified
     * index and shift the elements after the index to the right.
     * 
     *  Visualization:
     * 
     *  Array:
     *                  [5][12][25][32][40][51]
     *  
     *  Num : 20, will place in array
     *   
     *  index: 2
     * 
     *  Fist Array:             Last Array:
     *      [5][12][25]             [25][32][40][51]
     * 
     *  Change the end of the first array with number and concat 
     *  two array give use
     *  
     *              [5][12][20][25][32][40][51]
     *  
     *  Number placed the right location. We make it faster without a loop.
     *      
     * 
     */

    private void shiftSwap(int index, int number){
        // copy the first part that 0 index to "index" 
        // copy 1 more slot for when add number it will place there
        int firstPart[] = Arrays.copyOfRange(this.sortedArray,0,index);

        // copy the last part of the array
        int lastPart[] = Arrays.copyOfRange(this.sortedArray, index, this.sortedArray.length);


        // Change the last element
        firstPart[-1] = number;

        // concat to piece
        int newSortedArray[] = this.concatTwoArray(firstPart, lastPart);

        // maka change of global sorted array
        this.sortedArray = newSortedArray;

    }



    /*
     *  This function append number to array in the rigth order.
     *   
     * 
     *  @prob
     *      int num : number that will add to array
     *  
     */

    private void sortAppend(int num){
        
        // iterate first item to last item to mark difference 
        for(int i=0 ; i <= this.arrayİndex ; i++ ){
            
            // find the bigger number than "num"
            if(this.sortedArray[i] > num){
                
                // swap elements
                this.shiftSwap(i, num);

            }
        }

    }


    /*
     * 
     *  Function reads file line by line and make change in global 
     *  array.
     * 
     * 
     * 
     * 
     */


    public boolean sortWhenReading() throws FileNotFoundException{
        Scanner reader = new Scanner(this.file);

        // for calculate iteration time
        int iter = 0;
        

        while(reader.hasNextLine()){
            // we are inserting first index we will measuer time
            if(iter == 0){
                this.timer.startTimer();
                
                // make same operation
                int num = Integer.parseInt(reader.nextLine());
                this.sortAppend(num);

                this.timer.stopTimer();

                // store information
                this.statusInformations.put("b",this.timer.getElepsedTime());

            }else if(iter == 900000){
                // make same operation
                int num = Integer.parseInt(reader.nextLine());

                this.sortAppend(num);

                this.timer.stopTimer();

                // store information
                this.statusInformations.put("d",this.timer.getElepsedTime());

            }
            else{
        
                int num = Integer.parseInt(reader.nextLine());
                this.sortAppend(num);
            }

            iter++;
                
        }

        reader.close();
        
        return true;
    }
















    public int[] getArray(){
        return this.sortedArray;
    }

    public void printArr(int[] arr){
        for (int i=0 ; i<arr.length; i++)
            System.out.println(arr[i]);
    }

    
    public static void main(String str[]) throws FileNotFoundException{

        int arr[] = { 5, 12, 25, 32, 40, 52, 61 };

        

        SortingWithArray S = new SortingWithArray(str[0]);
        S.sortWhenReading();
        S.printArr(S.getArray());
        
    }



}
