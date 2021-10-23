import java.util.Iterator;
public class ReverseGLLIterator<T>  implements Iterator<T> {
    private GenericList<T>.Node<T> current;
    public ReverseGLLIterator(GenericQueue<T> list){
        current = list.tail;
    }
    public ReverseGLLIterator(GenericStack<T> list){
        current = list.tail;
    }
    public boolean hasNext(){
        return current != null;
    }
    public T next(){
        T val = current.data;
        current = current.prev;
        return val;
    }
}
