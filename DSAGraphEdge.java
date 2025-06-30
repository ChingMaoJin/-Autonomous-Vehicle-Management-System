public class DSAGraphEdge {
    private DSAGraphVertex From;
    private DSAGraphVertex To;
    private String Label; //name of the road
    private double Value; //distance of the road

    public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel, double inValue)
    {
        From=fromVertex;
        To=toVertex;
        Label=inLabel;
        Value=inValue;
    }

    public String getLabel()
    {
        return Label;
    }

    public double getValue()
    {
        return Value;
    }

    public DSAGraphVertex getTo()
    {
        return To;
    }

    public DSAGraphVertex getFrom()
    {
        return From;
    }
}
