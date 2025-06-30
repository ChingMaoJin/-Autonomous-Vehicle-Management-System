public class DSAHashTable {
    private DSAHashEntry [] hashArray;
    private int Count;
    private int Size;

    public DSAHashTable(int tableSize)
    {
        this.Size=findNextPrime(tableSize);
        hashArray=new DSAHashEntry[Size];
        for(int i=0; i<Size; i++)
        {
            hashArray[i]=new DSAHashEntry();  //initialize each entry in hashArray
        }
        Count=0;
    }

    private int CountNumVehicle(String source, String dest) //count the number of vehicle with the same source and dest
    {
        int Count=0;
        try
        {
            for(int i=0;i<hashArray.length; i++)
            {
                Vehicle Details=(Vehicle)hashArray[i].getValue();
                if(Details!=null)
                {
                    DSAGraphVertex curPosition=Details.getLocation();
                    String CurrentPosition=curPosition.getLabel();
                    DSAGraphVertex Dest=Details.getDestination();
                    String Destination=Dest.getLabel();
                    if(CurrentPosition.equals(source) && Destination.equals(dest))
                    {
                        Count++;
                    }
                }
            }
        }

        catch(Exception e)
        {
            System.out.println("Error detail: " + e.getMessage());
        }
        return Count;
    }

    public double find_Vehicle_With_HighestBattery(String source, String dest)
    {
        double BatLevel=0.0;
        int j=0;
        try
        {
            int Size=CountNumVehicle(source, dest);
            double [] Arr=new double[Size];
            DSAQuickSort Sort=new DSAQuickSort();
            for(int i=0;i<hashArray.length; i++)
            {
                Vehicle Details=(Vehicle)hashArray[i].getValue();
                if(Details !=null)
                {
                    DSAGraphVertex curPosition=Details.getLocation();
                    String CurrentPosition=curPosition.getLabel();
                    DSAGraphVertex Dest=Details.getDestination();
                    String Destination=Dest.getLabel();
                    if(CurrentPosition.equals(source) && Destination.equals(Destination))
                    {
                        Arr[j]=Details.getBatteryLevel();
                        j++;
                    }
                }
            }
            Sort.QuickSort(Arr, 0, Arr.length-1);
            BatLevel=Arr[0];
        }

        catch(ArrayIndexOutOfBoundsException e) //size return from CountNumVehicle is 0
        {
            System.out.println("There's no vehicle from " + source + " to " + dest + " .");
        }

        catch(Exception e)
        {
            System.out.println("Error details: " + e.getMessage());
        }
        return BatLevel;
    }

    public Vehicle recommenVehicle(String Source, String Dest)
    {
        Vehicle recomVehicle=null;
        Vehicle Details;
        double HighBatLevel=find_Vehicle_With_HighestBattery(Source, Dest);
        try
        {
            for(int i=0; i<Size; i++)
            {
                Details=(Vehicle)hashArray[i].getValue();
                if(Details!=null)
                {
                    DSAGraphVertex OriginPosition=Details.getLocation();
                    String Origin=OriginPosition.getLabel();
                    DSAGraphVertex DestPosition=Details.getDestination();
                    String Destination=DestPosition.getLabel();
                    double BatLevel=Details.getBatteryLevel();
                    if(Origin.equals(Source) && Destination.equals(Dest) && BatLevel==HighBatLevel)
                    {
                        recomVehicle=Details;
                    }
                }

            }
        }

        catch(Exception e)
        {
            System.out.println("Error details: " + e.getMessage());
        }
        return recomVehicle;
    }

    private int hash(String Key)
    {
        int hashIndex=0;
        for(int i=0; i<Key.length(); i++) //iterate through the each character in the String.
        {
            hashIndex=(hashIndex * 31) + Key.charAt(i);
        }
        hashIndex=Math.abs(hashIndex) % Size;
        return hashIndex;
    }

    private int findNextPrime(int StartVal)
    {
        int primeVal=0;
        if(StartVal<=2)
        {
            primeVal=3;
        }

        else
        {
            if(StartVal %2==0)
            {
                primeVal=StartVal-1;
            }

            else
            {
                primeVal=StartVal;
            }
            boolean isPrime=false;
            do
            {
                primeVal=primeVal+2;
                int i=3;
                isPrime=true;
                double rootVal=Math.sqrt(primeVal);
                do
                {
                    if(primeVal % i==0)
                    {
                        isPrime=false;
                    }

                    else
                    {
                        i=i+2;
                    }
                }while(i<=rootVal && isPrime);
            }while(!isPrime);
        }
        return primeVal;
    }

    public boolean hasKey(String inKey)
    {
        boolean has=false;
        if(get(inKey)!=null)
        {
            has=true;
        }
        return has;
    }


    public void put(String inKey, Object inValue)
    {
        DSAHashEntry newEntry=new DSAHashEntry(inKey, inValue);
        int hashIndex=hash(inKey);
        while(hashArray[hashIndex].getState()==1 && !hasKey(inKey)) //face collision
        {
            hashIndex=(hashIndex + 1) % Size;  //linear probing
            //System.out.println(hashIndex);
        }

        hashArray[hashIndex]=newEntry;
        hashArray[hashIndex].setState(1); //update the state
        Count++;

        if(getLoadFactor()> 0.7)
        {
            resize(Size);
        }
    }

    public Object get(String inKey)
    {
        int hashIndex=hash(inKey);
        Object Value=null;
        boolean found = false;
        while(hashArray[hashIndex].getState()!=0 && !found) // Either currently in used and used b4
        {
            if(hashArray[hashIndex].getKey()!=null && hashArray[hashIndex].getKey().equals(inKey))
            {
                Value=hashArray[hashIndex].getValue();
                found = true;
            }

            else
            {
                hashIndex=(hashIndex+ 1) % Size;
            }
        }
        return Value;
    }

    public int findKey(String inKey)  //returning the index of the targeted key
    {
        int hashIndex=hash(inKey);
        boolean Found=false;
        while(hashArray[hashIndex].getState()!=0 && !Found && hashArray[hashIndex].getKey()!=null)
        {
            if(hashArray[hashIndex].getKey().equals(inKey))
            {
                Found=true;
            }

            else
            {
                hashIndex=(hashIndex + 1) % Size;
            }
        }
        return hashIndex;
    }

    public Object remove(String inKey)
    {
        Object deletedValue;
        int Index=findKey(inKey);
        deletedValue=hashArray[Index].getValue();
        hashArray[Index].setKey(null);
        hashArray[Index].setValue(null);
        hashArray[Index].setState(-1);
        if(getLoadFactor()<0.4 && Size>10) //table is quite empty
        {
            resize(Size);
        }
        return deletedValue;
    }

    private void resize(int currentSize)
    {
        double LoadFactor=getLoadFactor();
        DSAHashEntry [] oldArray=hashArray;
        if(LoadFactor>0.7) //The table is quite full
        {
            Size=findNextPrime(currentSize * 2);
        }

        else if(getLoadFactor()<0.4 && Size>10) //The table is quite empty
        {
            Size=findNextPrime(currentSize/2);
        }

        hashArray=new DSAHashEntry[Size];
            Count=0;
            for(int i=0; i<Size; i++)
            {
                hashArray[i]=new DSAHashEntry();
            }

            for(int i=0; i<oldArray.length; i++)
            {
                if(oldArray[i]!=null && oldArray[i].getState()==1)
                {
                    put(oldArray[i].getKey(), oldArray[i].getValue());
                }
            }
    }

    private double getLoadFactor()
    {
        double LF=(double)Count/Size;
        return LF;
    }


    public void DisplayHashTable()
    {
        for(int i=0; i<Size; i++)
        {
            if(hashArray[i].getKey()!=null && hashArray[i].getState() !=0 && hashArray[i]!=null)
            {
            System.out.println("The VehicleID at index " + i + " is: " + hashArray[i].getKey());
            Vehicle Details=(Vehicle)hashArray[i].getValue();
            System.out.println("The battery level of the vehicle at index " + i + " is: " + Details.getBatteryLevel());
            DSAGraphVertex currentL=Details.getLocation();
            String currentCity=currentL.getLabel();
            System.out.println("The current location of the vehicle is: " + currentCity);
            DSAGraphVertex Dest=Details.getDestination();
            String DestCity=Dest.getLabel();
            System.out.println("The destination of the vehicle is: " + DestCity);
            double Distance=(double)Details.getDistanceToDestination();
            System.out.println("The distance to destination is: " + Distance);
            }
        }
    }

    public void DisplayKeyValue(String inKey)
    {
        Vehicle Details=(Vehicle)get(inKey);
        if(Details !=null)
        {
            System.out.println("Vehicle ID: " + inKey);
            System.out.println("Battery Level: " + Details.getBatteryLevel());
            System.out.println("Current Position: " + Details.getLocation().getLabel());
            System.out.println("Destination: " + Details.getDestination().getLabel());
            System.out.println("Distance to Destination: " + Details.getDistanceToDestination());
        }

        else
        {
            System.out.println("Can't find the details of the vehicle with the id provided");
        }
    }
}
