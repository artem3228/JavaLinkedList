import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class GenericList <T> implements Iterable<T> {
    // Node class
    class Node <U>{
        U data;
        // I want to implement double linked list
        Node<U> next;
        Node<U> prev;
        public Node(U val){
            data = val;
            prev = null;
            next = null;

        }
    }
    private Node<T>head;
    private int length;
    // Printing list
    public void print(){
        Node<T> current = head;
        System.out.println("The List contains: ");
        // if current == null then we are at the end
        while(current != null)
        {
            System.out.print(current.data);
            System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }
    public abstract T add(T elem);
    // delete function
    public T delete(){
        if(head == null)
            return null;
        T ret = head.data;
        if (head.next != null)  // changing an edge from prev node to current
            head.next.prev = null;
        head = head.next;
        length--;  // we deleted element
        return ret;
    }
    // dumping linked list into ArrayList
    public ArrayList<T> dumpList(){
        ArrayList<T> ret = new ArrayList<>();
        while(head != null){
            ret.add(delete());
        }
        return ret;
    }
    // Get element at index
    public T get(int index){
        int cur_ind = 0;  // current index
        Node<T> cur = head;
        while(cur != null){
            if(cur_ind == index)
                return cur.data;
            cur_ind++;
            cur = cur.next;
        }
        return null;  // out of bounds
    }
    // set element at index
    public T set(int index, T element) {
        int cur_ind = 0; // cur index
        Node<T> cur = head;
        while (cur != null) {
            if (cur_ind == index) {
                T data = cur.data;
                cur.data = element;
                return data;
            }
            cur_ind++;
            cur = cur.next;
        }
        return null; // out of bounds
    }
    // get length
    public int getLength() {
        return length;
    }
    // set length
    public void setLength(int x){
        length = x;
    }
    // get head
    public Node<T> getHead(){
        return head;
    }
    // set head to elem
    public void setHead(T elem){
        Node<T> cur = new Node<>(elem);
        if(head == null){  // we have to create
            head = cur;
        }
        else {
            if(elem == null)  // if I want to set a head to null
                head = null;
            else  // otherwise update data in the head
                head.data = elem;
        }
    }
    // iterator
    public Iterator<T> iterator() {
        return new GLListIterator<T>(this);
    }
}
