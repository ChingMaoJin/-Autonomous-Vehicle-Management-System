public class DSAHeapEntry
{
    private double priority;
    private Object Value;

    public DSAHeapEntry()
    {
        this.priority=0;
        Value=null;
    }

    public DSAHeapEntry(double priority, Object Value)
    {
        this.priority=priority;
        this.Value=Value;
    }

    public double getPriority()
    {
        return priority;
    }

    public void setPriority(double newPriority)
    {
        priority=newPriority;
    }

    public Object getValue()
    {
        return Value;
    }

    public void setValue(Object newValue)
    {
        Value=newValue;
    }
}