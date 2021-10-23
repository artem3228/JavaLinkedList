import java.util.ListIterator;

public  class GLListIterator<T> implements ListIterator<T> {
    private GenericList<T>.Node<T> current;
    // Constructor for Linked List
    public GLListIterator(GenericList<T> list){
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

    public T previous(){
        T val = current.data;
        current = current.prev;
        return val;
    }
    public boolean hasPrevious() {
        return current != null;
    }
    public int nextIndex() {
        return 0;
    }
    public int previousIndex() {
        return 0;
    }
    public void remove() {

    }
    public void set(T t) {

    }
    public void add(T t){

    }
}
