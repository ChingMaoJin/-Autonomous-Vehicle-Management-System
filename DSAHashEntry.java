public class DSAHashEntry
{
    private String Key;
    private Object Value;
    private int State; //0- never used, 1-Currently Used, -1: Used before

    public DSAHashEntry()
    {
        Key=null;
        Value=null;
        State=0;
    }

    public DSAHashEntry(String inKey, Object inValue)
    {
        Key=inKey;
        Value=inValue;
        State=0;  //initialize each entry in the hash table to not being used before
    }

    public String getKey()
    {
        return Key;
    }

    public Object getValue()
    {
        return Value;
    }

    public void setKey(String newKey)
    {
        Key=newKey;
    }

    public void setValue(Object newValue)
    {
        Value=newValue;
    }

    public int getState()
    {
        return State;
    }

    public void setState(int newState)
    {
        State=newState;
    }
}