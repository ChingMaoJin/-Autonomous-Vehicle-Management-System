public class DSALinkedList 
{
    private DSAListNode head;
    private DSAListNode tail;
    
    public DSALinkedList()
    {
        head=null;
        tail=null;
    }

    public void InsertFirst(Object newValue)
    {
        DSAListNode newNode=new DSAListNode(newValue);
        if(isEmpty())
        {
            head=newNode;
            tail=newNode;
        }

        else
        {
            newNode.setNext(head);
            head.setPrev(newNode);
            head=newNode; 
        }
    }

    public boolean isEmpty()
    {
        boolean empty=false;
        if(head==null)
        {
            empty=true;
        }

        else
        {
            empty=false;
        }
        return empty;
    }

    public void InsertLast(Object newValue)
    {
        DSAListNode newNode=new DSAListNode(newValue);
        if(isEmpty())
        {
            head=newNode;
            tail=newNode;
        }

        else
        {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail=newNode;
        }
    }

    public Object peekFirst()
    {
        Object NodeValue=null;
        if(isEmpty())
        {
            NodeValue=null;
        }

        else
        {
            NodeValue=head.getValue();
        }
        return NodeValue;
    }

    public DSAListNode getHead()
    {
        return head;
    }

    public Object peekLast()
    {
        Object NodeValue=null;
        if(isEmpty())
        {
            NodeValue=null;
        }

        else
        {
            NodeValue=tail.getValue();
        }
        return NodeValue;
    }

    public Object removeFirst()
    {
        Object NodeValue=null;
        if(isEmpty())
        {
            NodeValue=null;
        }

        else
        {
            NodeValue=head.getValue();
            head=head.getNext();
        }
        return NodeValue;
    }

    public Object removeLast()
    {
        Object NodeValue=null;
        if(isEmpty())
        {
            NodeValue=null;
        }

        else if(head.getNext()==null)
        {
            NodeValue=head.getValue();
            head=null;
        }

        else
        {
            NodeValue=tail.getValue();
            tail=tail.getPrev();
            tail.setNext(null);
        }
        return NodeValue;
    }

    public int CountNodes()
    {
        int Count=0;
        DSAListNode CurrentNode=head;
        while(CurrentNode !=null)
        {
            Count++;
            CurrentNode=CurrentNode.getNext();
        }
        return Count;
    }

    public Object removeNode(Object TargetNode)
    {
        Object NodeValue=null;
        if(isEmpty())
        {
            NodeValue=null;
        }

        else if(head.getNext()==null)
        {
            NodeValue=head.getValue();
            head=null;
            tail=null;
        }

        else
        {
            DSAListNode CurrentNode=head;
            while(CurrentNode !=null)
            {
                if(CurrentNode.getValue()==TargetNode) //head is the node to delete
                {
                    NodeValue=TargetNode;
                    DSAListNode prevNode=CurrentNode.getPrev();
                    DSAListNode nodeAfter=CurrentNode.getNext();
                    if(CurrentNode ==head) //the head is to remove
                    {
                        head=nodeAfter;
                        CurrentNode.setNext(null);
                        head.setPrev(null);
                    }

                    else if(CurrentNode==tail) //tail is the node to delete
                    {
                        tail=prevNode;
                        CurrentNode.setPrev(null);
                        tail.setNext(null);
                    }

                    else
                    {
                        CurrentNode.setNext(null);
                        CurrentNode.setPrev(null);
                        prevNode.setNext(nodeAfter);
                        nodeAfter.setPrev(prevNode);
                    }
                }
                CurrentNode=CurrentNode.getNext();
            }
        }
        return NodeValue;
    }

    public void displayLinkedList()
    {
        if(isEmpty())
        {
            System.out.println("The list is empty");
        }

        else
        {
            DSAListNode CurrentNode=head;
            while(CurrentNode !=null)
            {
                System.out.print(" " + CurrentNode.getValue());
                CurrentNode=CurrentNode.getNext();
            }
            System.out.println();
        }
    }

    public Object FindNode(Object Label)
    {
        DSAListNode CurrentNode=head;
        Object TargetNode=null;
        while(CurrentNode !=null)
        {
            if(CurrentNode.getValue().equals(Label))
            {
                TargetNode=CurrentNode.getValue();
            }
            CurrentNode=CurrentNode.getNext();
        }
        return TargetNode;
    }

    public Object getElement(int Index)
    {
        int TargetIndex=Index;
        int CurrentIndex=0;
        Object TargetVertex=null;
        if(CurrentIndex==TargetIndex)
        {
            TargetVertex=head.getValue();
        }

        DSAListNode CurrentNode=head;
        while(CurrentNode.getNext() !=null)
        {
            CurrentIndex++;
            CurrentNode=CurrentNode.getNext();
            if(CurrentIndex==TargetIndex)
            {
                TargetVertex=CurrentNode.getValue();
            }
        }
        return TargetVertex;
    }
}
