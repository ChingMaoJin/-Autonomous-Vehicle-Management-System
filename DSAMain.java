import java.util.InputMismatchException;
import java.util.Scanner;

public class DSAMain {
    public static void main(String[] args) 
    {
        DSAGraph Graph=new DSAGraph();
        char Choice;
        int VehicleID;
        String curP, dest;
        Object Distance_To_Dest;
        double BatLevel;
        DSAGraphVertex curPosition;
        DSAGraphVertex DestCity;
        Vehicle V;
        DSAHashTable Table=new DSAHashTable(1);
        Scanner sc=new Scanner(System.in);
        try
        {
        //road network
        System.out.println("Please enter the details below for road network.");
        do
        {
            System.out.println("a)Adding a city");
            System.out.println("b)Adding a road");
            System.out.println("c)Display the road network");
            System.out.println("d)Retrieving Neighbors");
            System.out.println("e)Checking for path existance");
            System.out.println("f)Adding a vehicle");
            System.out.println("g)Removing a vehicle");
            System.out.println("h)recommend a vehicle");
            System.out.println("j)Display all vehicles");
            System.out.println("k)exit: ");
            System.out.println("Your choice: ");
            Choice=sc.next().charAt(0);
            switch(Choice)
            {
                case 'a':
                case 'A':
                {
                    System.out.println("Please enter the name of the city: ");
                    String City=sc.next();
                    Graph.addVertex(City);
                    break;
                }

                case 'b':
                case 'B':
                {
                    try
                    {
                    System.out.println("Please specify the two cities: ");
                    String city1=sc.next();
                    String city2=sc.next();
                    System.out.println("Please enter the distance between the cities: ");
                    double Distance=sc.nextDouble();
                    String Label=city1+city2+"road";
                    Graph.addEdge(city1, city2, Label, Distance);
                    }

                    catch(InputMismatchException e)
                    {
                        System.err.println("Error detail: Input Mismatch Exception");
                        sc.nextLine(); //read off the mismatch input remained in the buffer
                    }
                    break;
                }

                case 'c':
                case 'C':
                {
                    System.out.println("Here's the display of the available cities: ");
                    Graph.displayVertexList();
                    System.out.println("Here's the display of the adjacent cities: ");
                    Graph.displayAsList();
                    System.out.println("Here's the display of the distance between the cities: ");
                    Graph.displayEdgeList();
                    break;
                }

                case 'd':
                case 'D':
                {
                    System.out.println("Which location do you want to retrieve from? ");
                    String Location=sc.next();
                    Graph.DisplayNeighbor(Location);
                    break;
                }

                case 'e':
                case 'E':
                {
                    System.out.println("Please enter two cities that you want to check path: ");
                    String L1=sc.next();
                    String L2=sc.next();
                    if(Graph.is_path(L1, L2))
                    {
                        System.out.println("There's a path from " + L1 + " to " + L2 + ".");
                    }

                    else
                    {
                        System.out.println("the path does not exists.");
                    }
                    break;
                }

                case 'f':
                case 'F':
                {
                    try
                    {
                        System.out.println("Please enter the details for vehicle. ");
                        System.out.println("Please enter the vehicle ID in integer: ");
                        VehicleID=sc.nextInt();
                        System.out.println("Please enter the current city of the vehicle");
                        curP=sc.next();
                        curPosition=new DSAGraphVertex(curP, curP);
                        System.out.println("Please enter the destination of the vehicle: ");
                        dest=sc.next();
                        DestCity=new DSAGraphVertex(dest, dest);
                        if(Graph.is_path(curP, dest))
                        {
                        Distance_To_Dest=Graph.getDistance(curP, dest);
                        do
                        {
                            System.out.println("Please enter the battery level of the vehicle: ");
                            BatLevel=sc.nextDouble();
                            if(BatLevel<=0 || BatLevel>100)
                            {
                                System.out.println("Please enter the battery level again. ");
                            }
                        }while(BatLevel<=0.0 || BatLevel>100);
                        V=new Vehicle(VehicleID, curPosition, DestCity, Distance_To_Dest, BatLevel);
                        String StrID=Integer.toString(VehicleID);
                        Table.put(StrID, V);
                        }

                        else
                        {
                            System.out.println("The path does not exist");
                        }
                    }

                    catch(InputMismatchException e)
                    {
                        System.out.println("Exception Error detail: input mismatch exception ");
                        sc.nextLine(); //to read off any input mismatch in the buffer
                        System.out.println("Returning to main menu. ");
                    }
                    break;
                }

                case 'g':
                case 'G':
                {
                    System.out.println("Please enter the vehicle ID that you want to remove: ");
                    String ID=sc.next();
                    if(Table.hasKey(ID))
                    {
                        Table.remove(ID);
                    }

                    else
                    {
                        System.out.println("The vehicle does not exist. ");
                    }
                    break;
                }

                case 'h':
                case 'H':
                {
                    try
                    {
                        System.out.println("Please enter your current location: ");
                        String Current=sc.next();
                        System.out.println("Please enter your destination: ");
                        String Dest=sc.next();
                        Vehicle recomVehicle=Table.recommenVehicle(Current, Dest);
                        if(recomVehicle !=null)
                        {
                            System.out.println("The shortest distance from " + Current + " to " + Dest + " is: " + Graph.getDistance(Current, Dest));
                            System.out.println("The highest battery level of the vehicle is: " + Table.find_Vehicle_With_HighestBattery(Current, Dest));
                            System.out.println("The recommended vehicle is with the ID: " + recomVehicle.getVehicleID());
                        }

                        else
                        {
                            System.out.println("Can't find the vehicle with the destination and current position provided");
                        }
                        
                    }

                    catch(Exception e)
                    {
                        System.out.println("Error detail: " + e.getMessage());
                    }
                    break;
                }

                case 'j':
                case 'J':
                {
                    Table.DisplayHashTable();
                    break;
                }

                case 'k':
                case 'K':
                {
                    System.out.println("Thank you for using the program. Bye!");
                    break;
                }

                default:
                {
                    System.out.println("Invalid input. Please enter again.");
                    break;
                }
            }
        }while(Choice!='k' && Choice!='K');
        }

        catch(Exception e)
        {
            System.out.println("Error detail: " + e.getMessage());
        }
        sc.close();
    }
}
