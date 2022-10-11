package pa1;

import java.util.HashMap;
import java.util.Map;

public class DynamicArrayCustom
{
    private int array[];
    private int count;
    private int size;
    private Map<String,Long> statusInformations;
    private TimeCounter timer;

    public DynamicArrayCustom() // constructor without parameter
    {
        count = 0;
        size = 1;
        array = new int[1];
    }

    public DynamicArrayCustom(int[] array) //dynamic array constructor with an array as parameter
    {
        this.timer = new TimeCounter();
        this.timer.startTimer();
        this.array = array;
        this.statusInformations = new HashMap<String,Long>();
        size = 1;

        for (int i = 0; i < array.length; i++) {  //iterate through array and insert each element
            this.insertLast(array[i]);
        }
        this.timer.stopTimer();

        this.statusInformations.put("a",this.timer.getElepsedTime());
    }

    public void insertLast(int element)    //inserts element to the last index, grows size if it's full
    {
        this.timer = new TimeCounter();
        this.timer.startTimer();

        array[count++] = element;

        if(count == size)   //if it is full
        {
            this.doubleSize();
        }

        this.timer.stopTimer();
        this.statusInformations.put("c",this.timer.getElepsedTime());
    }

    public void insertFirst(int element)  //shifts the elements and inserts to the index 0
    {
        this.timer = new TimeCounter();
        this.timer.startTimer();

        if(count == 0)    // if dynamic array is empty
        {
            this.insertLast(element);
        }

        else    //shift then insert
        {
            for (int i = count; i >= 0 ; i--) {
                array[i+1] = array[i];
            }

            array[0] = element;

            if(++count == size)  //check if the array is full, if so grow size
            {
                this.doubleSize();
            }
        }

        this.timer.stopTimer();
        this.statusInformations.put("b",this.timer.getElepsedTime());
    }


    public void doubleSize()  // method to double the current size of the array and copy its element to the newly created array with twice the size
    {
        size *= 2;
        int tempArray[] = new int[size];

        System.arraycopy(array, 0, tempArray, 0, count);

        array = tempArray;
    }

    public int getAtIndex(int index)  // gets the element at desired index and returns, if index is invalid returns -999999
    {
        this.timer = new TimeCounter();
        this.timer.startTimer();

        if(!(index > count-1 || index < 0)){
            this.timer.stopTimer();
            if(index == 900_000){
                this.statusInformations.put("d",this.timer.getElepsedTime());
            }
            else if (index == 9){
                this.statusInformations.put("e",this.timer.getElepsedTime());
            }
            return array[index];
        }
        else
            return -999999;
    }

    public void insertAtIndex(int element, int index){
        if (index > count || index < 0){
            return;
        }
        else if (index == 0){
            this.insertFirst(element);
            return;
        }
        else if (index == count){
            this.insertLast(element);
            return;
        }

        for (int i = count; i >= 0 ; i--) {
            array[i+1] = array[i];
        }
        array[index] = element;
    }

    public void printStatus(){
        System.out.println("The integer dynamic array structure is built in "+ this.statusInformations.get("a") +" milliseconds.");
        System.out.println("An integer is inserted into the first index of the dynamic array in "+this.statusInformations.get("b")+" milliseconds.");
        System.out.println("An integer is inserted into the 900,000th index of the dynamic array in "+this.statusInformations.get("c")+" milliseconds.");
        System.out.println("An integer, which is "+this.statusInformations.get("d")+" , is read from the index 900,000 of the dynamic array in "+this.statusInformations.get("d")+" milliseconds.");
        System.out.println("An integer, which is "+this.statusInformations.get("e")+" , is read from the index 9 of the dynamic array in "+this.statusInformations.get("e")+" milliseconds.");
    }
}
