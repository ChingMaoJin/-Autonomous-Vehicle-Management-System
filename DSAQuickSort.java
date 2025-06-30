public class DSAQuickSort 
{
    public void QuickSort(double [] Arr, int low, int high)
    {
        try
        {
            if(low<high)
            {
                int pivotIdx=partition(Arr,low,high);
                QuickSort(Arr, low, pivotIdx-1); //sort the left partition
                QuickSort(Arr, pivotIdx+1, high); //sort the right partition
            }
        }

        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error detail: " + e.getMessage());
        }
    }

    public int partition(double [] Arr, int low, int high)
    {
        int pivotIdx=high; //set the last element as pivot
        double pivot=Arr[pivotIdx];
        int i=low-1;
            for(int j=low; j<=high; j++)
            {
                if(Arr[j]>=pivot)
                {
                    i++;
                    //swap the array
                    double temp=Arr[i];
                    Arr[i]=Arr[j];
                    Arr[j]=temp;
                    if(j==pivotIdx)
                    {
                        pivotIdx=i;
                    }
                }
            }
        return pivotIdx;
    }
}
