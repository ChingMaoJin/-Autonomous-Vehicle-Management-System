public class DSAStack 
{
    private DSALinkedList StackList;

    public DSAStack()
    {
        StackList=new DSALinkedList();
    }

    public void push(Object newValue)
    {
        StackList.InsertFirst(newValue);
    }

    public Object pop()
    {
        Object ValueRemoved=StackList.peekFirst();
        StackList.removeFirst();
        return ValueRemoved;
    }

    public void DisplayStack()
    {
        StackList.displayLinkedList();
    }

    public Object Top()
    {
        return StackList.peekFirst();
    }

    public boolean isEmpty()
    {
        return StackList.isEmpty();
    }
}
