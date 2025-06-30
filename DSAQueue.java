public class DSAQueue
{
    private DSALinkedList List;

    public DSAQueue()
    {
        List=new DSALinkedList();
    }

    public void Enqueue(Object Value)
    {
        List.InsertLast(Value);
    }

    public Object Dequeue()
    {
        Object ValueRemoved=List.peekFirst();
        List.removeFirst();
        return ValueRemoved;
    }

    public boolean isEmpty()
    {
        return List.isEmpty();
    }

    public Object peak()
    {
        return List.peekFirst();
    }

    public void DisplayQueue()
    {
        DSAListNode CurrentNode=List.getHead();
        int Count=0;
        while(CurrentNode !=null)
        {
            DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue();
            String Label=Vertex.getLabel();
            System.out.print(Label);
            Count++;
            if(Count %2==0) //When count is even
            {
                System.out.print(" "); //print a space in between 
            }
            CurrentNode=CurrentNode.getNext();
        }
        System.out.println();
    }
}
