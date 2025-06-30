public class DSAHeap {
    private DSAHeapEntry [] heap;
    private int Count;

    public DSAHeap(int heapSize)
    {
        heap=new DSAHeapEntry[heapSize];
        for(int i=0; i<heapSize; i++)
        {
            heap[i]=new DSAHeapEntry();
        }
        Count=0;
    }

    public void heapify()
    {
        for(int i=Count/2-1; i>=0; i--)
        {
            TrickeDown(i);
        }
    }

    public double findshortestDistance()
    {
        heapSort();
        return heap[0].getPriority();
    }

    public void heapSort()
    {
        heapify();
        int Length=Count; //Store the number of inserted entries in Heap
        for(int i=Count-1; i>=1; i--)
        {
            //swap the with index 0 and index i
            DSAHeapEntry temp=heap[0];
            heap[0]=heap[i];
            heap[i]=temp;
            Count--; //decrement the heap size after swapping the first element with the last element
            TrickeDown(0);
        }
        Count=Length; //Restore the Count value
    }

    public void add(double priority, Object Value)
    {
        DSAHeapEntry newEntry=new DSAHeapEntry(priority, Value);
        heap[Count]=newEntry;
        TrickleUp(Count);
        Count++;
    }

    public void TrickleUp(int currentIndex)
    {
        int parentIndex=(currentIndex-1)/2;
        while(currentIndex>0 && heap[currentIndex].getPriority()>heap[parentIndex].getPriority())
        {
            DSAHeapEntry temp=heap[parentIndex];
            heap[parentIndex]=heap[currentIndex];
            heap[currentIndex]=temp;
            currentIndex=parentIndex;
            parentIndex=(currentIndex-1)/2;
        }
    }

    public void TrickeDown(int currentIndex)
    {
        int LeftChildIdx=currentIndex*2+1;
        int RightChildIdx=LeftChildIdx+1;
        boolean keepGoing=true;
        while(keepGoing && LeftChildIdx<Count)
        {
            keepGoing=false;
            int largeIdx=LeftChildIdx;
            if(RightChildIdx< Count)
            {
                if(heap[LeftChildIdx].getPriority() < heap[RightChildIdx].getPriority())
                {
                    largeIdx=RightChildIdx;
                }
            }

            if(heap[largeIdx].getPriority()> heap[currentIndex].getPriority())
            {
                DSAHeapEntry temp=heap[currentIndex];
                heap[currentIndex]=heap[largeIdx];
                heap[largeIdx]=temp;
                keepGoing=true;
            }
            currentIndex=largeIdx;
            LeftChildIdx=currentIndex*2+1;
            RightChildIdx=LeftChildIdx+1;
        }
    }

    public void Display()
    {
        System.out.println("Count: " + Count);
        for(int i=0; i<Count; i++)
        {
            System.out.println(heap[i].getPriority());
            System.out.println(heap[i].getValue());
        }
        System.out.println();
    }
}
