import java.util.ArrayList;
import java.util.Iterator;
// stack is when you are adding to back and pop too
public class GenericStack<T> extends GenericList<T> implements Iterable<T> {
    Node<T> tail;  // tail "pointer
    // Constructor
    public GenericStack(T data){
        setHead(data);
        tail = getHead(); // set tail to head
        setLength(getLength() + 1);
    }
    public T add(T data){
        if(tail == null){  // if tail == null
            setHead(data); // then by implementation we don't have a head ( head == null)
            tail = getHead();
        }
        else{ // otherwise make an edge from cur tail to new tail and vice versa
            Node<T> new_tail = new Node<T>(data);
            new_tail.prev = tail;
            tail.next = new_tail;
            tail = new_tail;
        }
        setLength(getLength() + 1);
        return data;
    }
    public void push(T data){
        add(data);
    }
    // I have to override it since in original genetic list we are deleting from the front
    // and in stack you delete back
    @Override
    public T delete(){
        if(tail == null) {  // we don't have elements in the stack
            return null;
        }
        T val = tail.data;
        if(tail.prev != null){ // checking a case if we are not in the head(# of elements > 1)
            tail.prev.next = null;
        }
        else{  // otherwise we are at the head
            setHead(null);
        }
        tail = tail.prev;
        setLength(getLength() - 1);
        return val;
    }
    // Since we override delete we have to override dumpList
    @Override
    public ArrayList<T> dumpList(){
        ArrayList<T> ret = new ArrayList<>();
        while(getHead() != null){
            ret.add(delete());
        } // we added all elements to the ret and cleared our stack
        int n = ret.size();
        // now we have to reverse it
        ArrayList<T> ret_reversed = new ArrayList<T>();
        for(int i = n - 1; i >= 0; i--)
            ret_reversed.add(ret.get(i));
        // Comlexity won't change since getting all elements is O(n), and reversing is O(n) too
        // so we still have O(n)
        return ret_reversed;
    }
    public T pop(){
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
