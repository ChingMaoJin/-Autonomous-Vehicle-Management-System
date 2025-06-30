public class DSAGraph {
    private DSALinkedList Vertices; //vertices list
    private DSALinkedList Edges; //edge list
    private int NumOfEdge;

    public DSAGraph()
    {
        Vertices=new DSALinkedList();
        Edges=new DSALinkedList();
        NumOfEdge=0;
    }

    public void addVertex(String Label)
    {
        if(!hasVertex(Label))
        {
            DSAGraphVertex newVertex=new DSAGraphVertex(Label, Label);
            Vertices.InsertLast(newVertex);
        }
    }

    public void sortVertex()
    {
        DSAListNode CurrentNode=Vertices.getHead();
        char [] VertexLabel=new char[Vertices.CountNodes()];
        DSAGraphVertex [] SortedVertex=new DSAGraphVertex[Vertices.CountNodes()]; //Storing for reordering ltr
        int index=0;
        while(CurrentNode !=null)
        {
            DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue();
            VertexLabel[index]=Vertex.getLabel().charAt(0);
            SortedVertex[index]=Vertex;
            CurrentNode=CurrentNode.getNext();
            index++;
        }

        //bubble sort
        for(int i=0; i<VertexLabel.length-1; i++)
        {
            for(int j=0; j<VertexLabel.length-1-i; j++)
            {
                if(VertexLabel[j]>VertexLabel[j+1])
                {
                    //swap the char[] VertexLabel
                    char temp=VertexLabel[j];
                    VertexLabel[j]=VertexLabel[j+1];
                    VertexLabel[j+1]=temp;

                    //swap DSAGraphVertex[] SortedVertex
                    DSAGraphVertex tempVertex=SortedVertex[j];
                    SortedVertex[j]=SortedVertex[j+1];
                    SortedVertex[j+1]=tempVertex;
                }
            }
        }

        Vertices=new DSALinkedList(); //clear existing vertice list
        for(int i=0; i<VertexLabel.length; i++)
        {
            Vertices.InsertLast(SortedVertex[i]);
        }
    }

    public void addEdge(String L1, String L2, String EdgeLabel, double Distance)
    {
        DSAGraphVertex V1=getVertex(L1);
        DSAGraphVertex V2=getVertex(L2);
        if(V1 !=null && V2!=null)
        {
            V1.addNeighbors(V2);
            V2.addNeighbors(V1); 
            //adding the edge to the edge list
            DSAGraphEdge newEdge=new DSAGraphEdge(V2, V1, EdgeLabel, Distance);
            Edges.InsertFirst(newEdge); //insert the new edge into the edge list
            NumOfEdge++;
        }

        else
        {
            System.out.println("Vertices not found.");
        }
    }

    private DSAGraphEdge getEdge(String Label)
    {
        DSAGraphEdge TargetEdge=null;
        DSAListNode CurrentNode=Edges.getHead();
        while(CurrentNode !=null)
        {
            DSAGraphEdge Edge=(DSAGraphEdge)CurrentNode.getValue();
            if(Edge.getLabel().equals(Label))
            {
                TargetEdge=Edge;
            }
            CurrentNode=CurrentNode.getNext();
        }
        return TargetEdge;
    }

    private DSAGraphVertex getVertex(String Label)
    {
        DSAGraphVertex FoundVertex=null;
        DSAListNode CurrentNode=Vertices.getHead();
        while(CurrentNode !=null)
        {
            DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue();
            if(Vertex.getLabel().equals(Label))
            {
                FoundVertex=Vertex;
            }
            CurrentNode=CurrentNode.getNext();
        }
        return FoundVertex;
    }

    private boolean hasVertex(String Label)
    {
        boolean Has=false;
        if(getVertex(Label)!=null)
        {
            Has=true;
        }
        return Has;
    }

    public int getVertexCount()
    {
        return Vertices.CountNodes();
    }

    public int getEdgeCount()
    {
        return NumOfEdge;
    }

    public boolean isAdjacent(String L1, String L2)
    {
        boolean Is=false;
        DSAGraphVertex V1=getVertex(L1);
        DSAGraphVertex V2=getVertex(L2);
        if(V1!=null && V2!=null)
        {
            if(V1.hasNeighbors(V2))
            {
                Is=true;
            }
        }
        return Is;
    }

    public void displayAsList()
    {
        DSAListNode currentNode=Vertices.getHead();
        while(currentNode!=null)
        {
            DSAGraphVertex Vertex=(DSAGraphVertex)currentNode.getValue();
            Vertex.sortNeighbor();
            Vertex.DisplayNeighbor();
            currentNode=currentNode.getNext();
        }
    }

    public void DisplayNeighbor(String Label)
    {
        DSAListNode currentNode=Vertices.getHead();
        if(hasVertex(Label))
        {
            //tranversing the vertex list and find which DSAGraphVertex has the same label as argument
            while(currentNode!=null)
            {
                DSAGraphVertex Vertex=(DSAGraphVertex)currentNode.getValue();
                if(Vertex.getLabel().equals(Label))
                {
                    Vertex.DisplayNeighbor();
                }
                currentNode=currentNode.getNext();
            }
        }

        else
        {
            System.out.println("The city does not exist.");
        }
    }

    public void displayEdgeList()
    {
        DSAListNode CurrentNode=Edges.getHead();
        while(CurrentNode!=null)
        {
            DSAGraphEdge Edge=(DSAGraphEdge)CurrentNode.getValue();
            String Label=Edge.getLabel();
            System.out.println("RoadLabel:" + Label + " Distance:" + Edge.getValue() + ".");
            CurrentNode=CurrentNode.getNext();
        }
    }

    public void displayVertexList()
    {
        sortVertex();
        DSAListNode CurrentNode=Vertices.getHead();
        System.out.println("Here're the cities");
        while(CurrentNode !=null)
        {
            DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue();
            String Label=Vertex.getLabel();
            System.out.print(Label + " ");
            CurrentNode=CurrentNode.getNext();
        }
        System.out.println();
    }

    //helper method
    private boolean is_pathBFS(String Label1, String Label2)
    {
        boolean IsPath = false;
        DSAQueue Q = new DSAQueue();
        DSAListNode currentNode = Vertices.getHead();
        DSAGraphVertex V1 = getVertex(Label1);
        DSAGraphVertex V2 = getVertex(Label2);
        
        // Initialize all vertices to unvisited
        while (currentNode != null) 
        {
            DSAGraphVertex Vertex = (DSAGraphVertex)currentNode.getValue();
            Vertex.clearVisited();
            currentNode = currentNode.getNext();
        }
        V1.setVisited(true);
        Q.Enqueue(V1);
        while(!Q.isEmpty() && !IsPath)
        {
            V1=(DSAGraphVertex)Q.Dequeue();
            DSAGraphVertex W=getUnvisitedNeighbor(V1);
            while(W!=null && !IsPath)
            {
                if(W==V2)
                {
                    IsPath=true;
                }
                W.setVisited(true);
                Q.Enqueue(W);
                W=getUnvisitedNeighbor(V1);
            }
        }
        return IsPath;
    }


    public boolean is_path(String Label1, String Label2)
    {
        boolean Is=false;
        if(Label1.equals(Label2))
        {
            System.out.println("The source and destination is the same.");
        }

        else if(getVertex(Label1)==null || getVertex(Label2)==null)
        {
            System.out.println("The source or destination does not exist");
        }

        else
        {
            Is=is_pathBFS(Label1, Label2);  
        }
        return Is;
    }

    private int NumOfPath(String L1, String L2)
    {
        int pathCount=0;
        if(is_path(L1,L2))
        {
            DSAListNode CurrentNode=(DSAListNode)Vertices.getHead();
            while(CurrentNode!=null) //to clear visited for all the vertices
            {
                DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue(); //vertex in the vertices list
                Vertex.clearVisited();  //clear visited for all the vertices
                CurrentNode=CurrentNode.getNext();
            }
            DSAGraphVertex source=getVertex(L1);
            DSAGraphVertex Dest=getVertex(L2);
            pathCount=dfsCountPaths(source,Dest);
        }
        return pathCount;
    }

    // DFS helper method to count all paths from source to destination
    private int dfsCountPaths(DSAGraphVertex current, DSAGraphVertex Dest)
    {
        int pathCount=0;
        if(current == Dest)
        {
            pathCount=1;
        }
        current.setVisited(true);
        DSAListNode neighborNode=current.getNeighbors().getHead();
        while(neighborNode!=null)
        {
            DSAGraphVertex neighbor=(DSAGraphVertex)neighborNode.getValue();
            if(!neighbor.isVisited())
            {
                pathCount=pathCount+dfsCountPaths(neighbor, Dest);
            }
            neighborNode=neighborNode.getNext();
        }
        current.clearVisited();
        return pathCount;
    }

    private DSAGraphVertex getUnvisitedNeighbor(DSAGraphVertex V)
    {
        sortVertex();
        DSAGraphVertex UnvisitedNeighbor=null;
        DSAListNode CurrentNode=Vertices.getHead();
        while(CurrentNode !=null)
        {
            DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue();
            String VertexLabel=Vertex.getLabel();
            if(VertexLabel.equals(V.getLabel()))
            {
                DSALinkedList Neighbor=Vertex.getNeighbors();
                DSAListNode CurrentNeighborNode=Neighbor.getHead();
                while(CurrentNeighborNode!=null)
                {
                    DSAGraphVertex NeighborVertex=(DSAGraphVertex)CurrentNeighborNode.getValue();
                    if(!NeighborVertex.isVisited())
                    {
                        UnvisitedNeighbor=NeighborVertex;
                    }
                    CurrentNeighborNode=CurrentNeighborNode.getNext();
                }
            }
            CurrentNode=CurrentNode.getNext();
        }
        return UnvisitedNeighbor;
    }

    public double getDistance(String L1, String L2) //return the shortest distance of the path
    {
        double totalDistance = 0;
        int PathNum = NumOfPath(L1, L2); // Number of possible paths
        DSAHeap heapArray = new DSAHeap(PathNum); // Store all possible distances

        try 
        {
            if (is_path(L1, L2)) 
            {
                DSAGraphVertex startVertex = getVertex(L1);
                DSAGraphVertex destVertex = getVertex(L2);

                // Clear visited status for all vertices
                DSAListNode currentNode = (DSAListNode) Vertices.getHead();
                while (currentNode != null) 
                {
                    DSAGraphVertex vertex = (DSAGraphVertex)currentNode.getValue();
                    vertex.clearVisited();
                    currentNode = currentNode.getNext();
                }

                // Find all paths and store in heapArray
                findPaths(startVertex, destVertex, 0.0, heapArray, "");

                // Get the shortest distance from the heap
                totalDistance = heapArray.findshortestDistance();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error detail: " + e.getMessage());
        }
        return totalDistance;
    }

    // Helper method to find all paths using DFS
    private void findPaths(DSAGraphVertex currentVertex, DSAGraphVertex destVertex, double currentDistance, DSAHeap heapArray, String path) 
    {
        currentVertex.setVisited(true);
        path =path + currentVertex.getLabel() + " "; // Add current vertex to the path

        if (currentVertex == destVertex) // Base case: destination reached
        {
            heapArray.add(currentDistance, path.trim()); // Add the distance and path to the heap
        } 
        
        else 
        {
            // Traverse through neighbors linked list
            DSAListNode neighborNode = currentVertex.getNeighbors().getHead(); //getNeighbors() returns a linked list of neighbors
            while(neighborNode != null) 
            {
                DSAGraphVertex neighbor=(DSAGraphVertex)neighborNode.getValue();
                if(!neighbor.isVisited())
                {
                    String edgeLabel = getEdgeLabel(currentVertex.getLabel(), neighbor.getLabel());
                    DSAGraphEdge edge = getEdge(edgeLabel);
                    double edgeDistance = edge.getValue();
                    // Recursively find paths from the neighbor
                    findPaths(neighbor, destVertex, currentDistance + edgeDistance, heapArray, path);
                }
                neighborNode = neighborNode.getNext(); // Move to the next neighbor in the linked list
            }
        }
        //Mark the current vertex as unvisited for other possible paths
        currentVertex.clearVisited();
    }

    private String getEdgeLabel(String L1,String L2)
    {
        String EdgeLabel=null;
        try
        {
            DSAGraphVertex V1=getVertex(L1);
            DSAGraphVertex V2=getVertex(L2);
            DSAListNode currentNode=(DSAListNode)Edges.getHead();
            while(currentNode!=null)
            {
                DSAGraphEdge Edge=(DSAGraphEdge)currentNode.getValue();
                if((Edge.getTo()==V1 || Edge.getTo()==V2) && (Edge.getFrom()==V1 || Edge.getFrom()==V2))
                {
                    EdgeLabel=Edge.getLabel();
                }
                currentNode=currentNode.getNext();
            }
        }

        catch(Exception e)
        {
            System.out.println("Error detail: " + e.getMessage());
        }
        return EdgeLabel;
    }

    public void displayGraphStructure()
    {
        displayAsList();
        displayEdgeList();
        displayVertexList();
    }
}
