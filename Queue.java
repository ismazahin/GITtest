//header
import java.util.NoSuchElementException;
import java.util.*;

public class Queue extends LinkList
{
    //default constructor
    public Queue()
    { }
    //insert queue method
    public void enqueue(Object elem)
    {insertAtBack(elem);}
    //remove queue method
    public Object dequeue()
    { return removeFromFront();}
    //remove queue method with value Integer
    public Object dequeue(int s)
    { return removeFromFront();}
    //remove queue method with Queue inside parameter
    public Object dequeue(Queue Q)
    {
        return removeFromFront();
    }
    //Count data inside Queue
    public int size() {
        return count();
    }
    //getter
    public Object getFront()
    { return getFirst(); }
    
    public Object getEnd()
    {
        Object obj = removeFromBack();
        insertAtBack(obj);
        return obj;
    }
}
