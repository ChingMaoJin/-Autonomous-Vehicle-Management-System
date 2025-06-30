public class Vehicle
{
    private int VehicleID;
    private DSAGraphVertex CurrentPosition;
    private DSAGraphVertex Dest;
    private Object Dist_To_Dest;
    private double Battery_Level;

    public Vehicle(int VehicleID, DSAGraphVertex CurrentPosition, DSAGraphVertex Dest, Object Dist_To_Dest, double Battery_Level)
    {
        this.VehicleID=VehicleID;
        this.CurrentPosition=CurrentPosition;
        this.Dest=Dest;
        this.Dist_To_Dest=Dist_To_Dest;
        this.Battery_Level=Battery_Level;
    }

    public void setVehicleID(int ID)
    {
        VehicleID=ID;
    }

    public void setLocation(DSAGraphVertex Location)
    {
        CurrentPosition=Location;
    }

    public void setDestination(DSAGraphVertex destination)
    {
        Dest=destination;
    }

    public void setDistanceToDestination(Object Distance)
    {
        Dist_To_Dest=Distance;
    }

    public void setBatteryLevel(double Level)
    {
        Battery_Level=Level;
    }

    public DSAGraphVertex getLocation()
    {
        return CurrentPosition;
    }

    public DSAGraphVertex getDestination()
    {
        return Dest;
    }

    public Object getDistanceToDestination()
    {
        return Dist_To_Dest;
    }

    public double getBatteryLevel()
    {
        return Battery_Level;
    }

    public int getVehicleID()
    {
        return VehicleID;
    }
}