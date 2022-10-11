public class DynamicArrayCustom
{
    private int array[];
    private int count;
    private int size;

    public DynamicArrayCustom()
    {
        count = 0;
        size = 1;
        array = new int[1];
    }

    public DynamicArrayCustom(int[] array)
    {
        this.array = array;
        size = 1;

        for (int i = 0; i < array.length; i++) {
            this.insertLast(array[i]);
        }
    }

    public void insertLast(int element)
    {
        array[count++] = element;

        if(count == size)
        {
            this.doubleSize();
        }
    }

    public void insertFirst(int element)
    {
        if(count == 0)
        {
            this.insertLast(element);
        }

        else
        {
            for (int i = count; i >= 0 ; i--) {
                array[count+1] = array[count];
            }

            array[0] = element;

            if(++count == size)
            {
                this.doubleSize();
            }
        }
    }

    public void insertAtIndex(int element, int index)
    {
        if(index == 0)
        {
            this.insertFirst(element);
        }
        else if(index == count)
        {
            this.insertLast(element);
        }
        else if(index > count)
        {
            return;
        }
        else
        {
            for (int i = count; i >= index ; i--)
            {
                array[count+1] = array[count];
            }

            array[index] = element;

            if(++count == size)
            {
                this.doubleSize();
            }
        }
    }

    public void doubleSize()
    {
        size *= 2;
        int tempArray[] = new int[size];

        System.arraycopy(array, 0, tempArray, 0, count);

        array = tempArray;
    }

    public int getAtIndex(int index)
    {
        if(!(index > count-1))
            return array[index];
        else
            return -999999;
    }
}
