class LinkList
{
    private Node first;
    private Node current;
    private Node last;
    private int value;
    
    //default constructor
    public LinkList()
    {
        first = null; 
        last = null;
        current = null;
    }
    
    public LinkList(int value) {
        this.value = value;
    }
    //method to get certain value
    public int getValue() {
        return value;
    }

    //method to check whether file is empty
    public boolean isEmpty()
    {
        return (first==null);
    }
    //insertion at front with Object as parameter
    public void insertAtFront (Object insertItem)
    {
        Node newNode = new Node (insertItem);

        if (isEmpty()) 
        {   first = newNode; 
            last = newNode;
        }
        else
        {
            newNode.next = first;
            first = newNode;
        }
        }
    //insertion at back with Object as parameter
    public void insertAtBack (Object insertItem)
    {
        Node newNode = new Node (insertItem);
    
        if (isEmpty()) 
        {   first = newNode; 
            last = newNode;
        }
        else
        {
            last.next = newNode;
            last = newNode;

        }
    }
    //Remove from front method with integer as parameter condition
     public void removeFromFront(int index) {
        if (index < 0 || first == null) {
            // Handle invalid index or empty list scenario
            System.out.println("Invalid index or empty list!");
            return;
        }

        if (index == 0) {
            first = first.next;
            return;
        }

        Node current = first;
        Node previous = null;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }

        if (current != null) {
            previous.next = current.next;
        } else {
            // Handle index out of bounds scenario
            System.out.println("Index out of bounds!");
        }
    }
    //Remove from back method with integer as parameter condition
    public void removeFromBack(int indexFromEnd) {
        if (indexFromEnd < 0 || first == null) {
            // Handle invalid index or empty list scenario
            System.out.println("Invalid index or empty list!");
            return;
        }
    
        int size = 0;
        Node temp = first;
    
        // Calculate the size of the list
        while (temp != null) {
            temp = temp.next;
            size++;
        }
    
        int indexFromStart = size - indexFromEnd;
    
        if (indexFromStart < 0) {
            // Handle index out of bounds scenario
            System.out.println("Index out of bounds!");
            return;
        }
    
        if (indexFromStart == 0) {
            first = first.next;
            return;
        }
    
        Node current = first;
        Node previous = null;
        int currentIndex = 0;
    
        while (current != null && currentIndex < indexFromStart) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
    
        if (current != null) {
            previous.next = current.next;
        }
    }
    public Object removeFromFront()
    {
            Object removeItem = null;
            if (isEmpty()) 
            {
                return removeItem;
            }
            removeItem = first.data;
            if (first == last)
            {
                first = null;
                last = null;
            }
            else
                first = first.next;
                
            return removeItem;
    }
    public Object removeFromBack()
    {
        Object removeItem = null;   
        if (isEmpty())
        {
            return removeItem;
        }
        removeItem = last.data;
        if (first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            current = first;
            while (current.next != last)
            current = current.next;

            last = current;
            last.next = null;
        }
        return removeItem;
    }
    
    public Object getFirst()
    {
        if (isEmpty())
            return null;
        else
        {
            current = first;
            return current.data;
        }
    }
   public Object getNext()
    {
        if(current==last)
            return null;
        else {
            current = current.next;
            if(current != null)
             return current.data;
            else 
             return null;
        }
    }
    public int count()
    {
        int bil = 0;
        current=first;
        
        while(current != null)
        {
            current=current.next;
            bil++;
        }
        return bil;
    }
    
}
    
