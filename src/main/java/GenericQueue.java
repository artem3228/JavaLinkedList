import java.util.Iterator;
// queue is when you add to the tail, and delete from the front
public class GenericQueue<T> extends GenericList<T> implements Iterable<T> {
    Node<T> tail; // a "pointer" for the tail
    // A constructor for a class
    public GenericQueue(T elem){
        setHead(elem);
        tail = getHead();
        setLength(getLength() + 1);
    }
    // remove from the tail
    public T removeTail(){
        if(tail == null) // empty queue (can't remove)
            return null;
        else
        {
            T data = tail.data;
            if(tail == getHead()) // we have one element in the queue
            {
                delete();
                tail = null;
                setHead(null);
            }
            else {
                setLength(getLength() - 1);
                tail.prev.next = null;
                tail = tail.prev;
            }
            return data;
        }
    }
    // add to the tail
    public T add(T data){
        if(tail == null || getHead() == null){ // we have an empty queue
            setHead(data);
            tail = getHead();
        }
        else{
            Node<T> new_tail = new Node<T>(data);
            // making an edge from tail to new element
            tail.next = new_tail;
            new_tail.prev = tail;
            tail = new_tail;
        }
        setLength(getLength() + 1);  // increase # of elements
        return getHead().data;
    }
    public T enqueue(T data){
        return add(data);
    }
    public T dequeue(){
        return delete();
    }
    // getting an iterator (also for "for each" loop)
    public Iterator<T> iterator() {
        return new GLLIterator<T>(this);
    }
    // getting a reverse iterator
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<T>(this);
    }
}
