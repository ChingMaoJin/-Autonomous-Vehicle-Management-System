public class Test{
    public static void main(String[] args) {
        DSAGraph Graph=new DSAGraph();
        Graph.addVertex("A");
        Graph.addVertex("B");
        Graph.addVertex("C");
        Graph.addVertex("D");
        Graph.addVertex("E");
        Graph.addVertex("F");
        Graph.addVertex("G");
        Graph.addVertex("H");
        Graph.addVertex("I");
        Graph.addVertex("J");
        Graph.addEdge("A", "B", "roadAB", 110);
        Graph.addEdge("A", "D", "roadAD", 100);
        Graph.addEdge("A", "C", "roadAC", 1);
        Graph.addEdge("B", "E", "roadBE", 200);
        Graph.addEdge("D", "E", "roadDE", 150);
        Graph.addEdge("D", "H", "roadDH", 160);
        Graph.addEdge("D", "F", "roadDF", 3);
        Graph.addEdge("C", "F", "roadCF", 2);
        Graph.addEdge("E", "G", "roadEG", 300);
        Graph.addEdge("G", "H", "roadGH", 170);
        Graph.addEdge("G", "J", "roadGJ", 400);
        Graph.addEdge("H", "J", "roadHJ", 180);
        Graph.addEdge("H", "I", "roadHI", 5);
        Graph.addEdge("I", "J", "roadIJ", 6);
        Graph.addEdge("F", "I", "roadFI", 4);
        Graph.displayGraphStructure();
        DSAGraphVertex Source=new DSAGraphVertex("A", "A");
        DSAGraphVertex Dest=new DSAGraphVertex("J", "J");
        double dist_To_dest=Graph.getDistance("A", "J");
        System.out.println("The shortest distance is: " + dist_To_dest);
        Vehicle V1=new Vehicle(1, Source, Dest, dist_To_dest, 10);
        Vehicle V2=new Vehicle(2, Source, Dest, dist_To_dest, 20);
        DSAHashTable hashArray=new DSAHashTable(1);
        hashArray.put("1", V1);
        hashArray.put("2", V2);
        hashArray.DisplayHashTable();
        double highestBattery=hashArray.find_Vehicle_With_HighestBattery("A", "J");
        System.out.println("The highest battery level: " + highestBattery);
        double ShortestDist=Graph.getDistance("A", "J");
        System.out.println("The shortest distance is: " + ShortestDist);
        Vehicle recomVehicle=hashArray.recommenVehicle("A", "J");
        System.out.println("The recommended vehicle with the vehicle ID is: " + recomVehicle.getVehicleID());
    }
}
