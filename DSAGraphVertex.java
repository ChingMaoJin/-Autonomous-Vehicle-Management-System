public class DSAGraphVertex
{
    private String Label;
    private DSALinkedList Neighbors; //Adjacency list
    private boolean Visited;

    public DSAGraphVertex(String Label, String Value)
    {
        this.Label=Label;
        //this.Value=Value;
        Neighbors=new DSALinkedList();
        Visited=false;
    }

    public boolean isVisited()
    {
        return Visited;
    }

    public void setVisited(boolean Visited)
    {
        this.Visited=Visited;
    }

    public void clearVisited()
    {
        this.Visited=false;
    }

    public String getLabel()
    {
        return this.Label;
    }

    public DSALinkedList getNeighbors() 
    {
        return Neighbors;
    }

    public void addNeighbors(DSAGraphVertex NeighborVertex)
    {
        if(Neighbors.FindNode(NeighborVertex)==null)
        {
            Neighbors.InsertFirst(NeighborVertex);
        }

        else
        {
            System.out.println("The neighbor has already been added.");
        }
    }

    public void deleteNeighbors(DSAGraphVertex NeighborVertex)
    {
        if(Neighbors.FindNode(NeighborVertex) !=null) //found the node
        {
            Neighbors.removeNode(NeighborVertex);
        }
    }

    public boolean hasNeighbors(DSAGraphVertex Targetneighbor)
    {
        boolean Has=false;
        if(Neighbors.FindNode(Targetneighbor)!=null)
        {
            Has=true;
        }
        return Has;
    }

    public void DisplayNeighbor()
    {
        System.out.print("The neighbor of " + Label + "-> ");
        DSAListNode CurrentNode=Neighbors.getHead();
        while(CurrentNode!=null)
        {
            if(CurrentNode.getValue() instanceof DSAGraphVertex)
            {
            DSAGraphVertex NeighborVertex=(DSAGraphVertex)CurrentNode.getValue();
            String NeighborLabel=NeighborVertex.getLabel();
            System.out.print(NeighborLabel + " ");
            CurrentNode=CurrentNode.getNext();
            }
        }
        System.out.println();
    }

    public void sortNeighbor()
    {
        DSAListNode CurrentNode=Neighbors.getHead();
        int NumOfNeighbors=Neighbors.CountNodes();
        char [] CLabel=new char[NumOfNeighbors];
        DSAGraphVertex [] vertexArray=new DSAGraphVertex[NumOfNeighbors];
        int i=0;
        while(CurrentNode!=null)
        {
        DSAGraphVertex Vertex=(DSAGraphVertex)CurrentNode.getValue();
        String Label=Vertex.getLabel();
        CLabel[i]=Label.charAt(0);  //store the first character of the String and use it for bubble sort ltr 
        vertexArray[i]=Vertex;  //store the vertex for updating the adjacency list ltr
        CurrentNode=CurrentNode.getNext();
        i++;
        }

        //bubble sort
        for(i=0; i<CLabel.length-1; i++)
        {
            for(int j=0; j<CLabel.length-i-1; j++)
            {
                if(CLabel[j]>CLabel[j+1])
                {
                    //swap the CLabel Array
                    char temp=CLabel[j];
                    CLabel[j]=CLabel[j+1];
                    CLabel[j+1]=temp;

                    //swap the vertex array
                    DSAGraphVertex Temp=vertexArray[j];
                    vertexArray[j]=vertexArray[j+1];
                    vertexArray[j+1]=Temp;
                }
            }
        }

        //Update the sorted adjacency list
        Neighbors=new DSALinkedList(); //remove the existing adjacency list
        for(i=0; i<NumOfNeighbors; i++)
        {
            Neighbors.InsertLast(vertexArray[i]);
        }
    }
}
