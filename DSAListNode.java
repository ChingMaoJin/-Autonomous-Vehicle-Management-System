public class DSAListNode 
{
    private Object value;
    private DSAListNode next;
    private DSAListNode prev;

    public DSAListNode(Object inValue)
    {
        this.value=inValue;
        this.next=null;
        this.prev=null;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object inValue)
    {
        this.value=inValue;
    }

    public DSAListNode getNext()
    {
        return next;
    }

    public DSAListNode getPrev()
    {
        return prev;
    }

    public void setNext(DSAListNode newNext)
    {
        this.next=newNext;
    }

    public void setPrev(DSAListNode prevNode)
    {
        this.prev=prevNode;
    }

    public String toString()
    {
        return value.toString();
    }
}
