import java.util.Iterator;
public class GLLIterator<T> implements Iterator<T>  {
    private GenericList<T>.Node<T> current;
    // Constructor for Queue
    public GLLIterator(GenericQueue<T> list){
        current = list.getHead();
    }
    // Constructor for Stack
    public GLLIterator(GenericStack<T> list){
        current = list.getHead();
    }
    public boolean hasNext(){
        return current != null;
    }
    public T next(){
        T val = current.data;
        current = current.next;
        return val;
    }
}
