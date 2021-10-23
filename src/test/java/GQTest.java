import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Iterator;

public class GQTest {
    // Testing GeneticList get function
    @Test
    void getTest(){
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(3, q.get(0), "wrong value");
        assertEquals(1, q.get(1), "wrong value");
        assertEquals(3, q.get(2), "wrong value");
        assertEquals(4, q.get(3), "wrong value");
        assertEquals(null, q.get(5), "wrong value");
        assertEquals(null, q.get(-54), "wrong value");
    }
    // Testing GeneticList set function
    @Test
    void setTest(){
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(3, q.get(2), "wrong value");
        q.set(2, 8);
        assertEquals(8, q.get(2), "wrong value");
        assertEquals(null, q.set(5, -67), "wrong value");
        assertEquals(null, q.set(-5, 67), "wrong value");
    }
    // We are testing remove tail and length counter
    @Test
    void RemoveTailTest1() {
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        assertEquals(1, q.getLength(), "wrong value");
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        assertEquals(4, q.getLength(), "wrong value");
        assertEquals(7, q.removeTail(), "wrong value");
        assertEquals(6, q.removeTail(), "wrong value");
        assertEquals(5, q.removeTail(), "wrong value");
        assertEquals(1, q.getLength(), "wrong value");
        assertEquals(3, q.removeTail(), "wrong value");
        assertEquals(0, q.getLength(), "wrong value");
        // when the queue is empty, it should remove null
        assertEquals(null, q.removeTail(), "wrong value");
        // when the queue is empty, the length should be 0
        assertEquals(0, q.getLength(), "wrong value");
        assertEquals(null, q.removeTail(), "wrong value");
        assertEquals(0, q.getLength(), "wrong value");
    }
    // We are testing Enqueue function and dumplist function
    @Test
    void EnqueueTest() {
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        assertArrayEquals(a.toArray(), q.dumpList().toArray(), "wrong value");
        q.enqueue(3);
        q.enqueue(5);
        a.add(5);
        assertArrayEquals(a.toArray(), q.dumpList().toArray(), "wrong value");
        a.add(7);
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        assertArrayEquals(a.toArray(), q.dumpList().toArray(), "wrong value");
    }
    // We are testing Deque function and dumplist function
    @Test
    void DequeTest() {
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.remove(0);
        q.enqueue(5);
        q.enqueue(7);
        //q.print();
        q.dequeue();
        a.add(5);
        a.add(7);
        //q.print();
        assertArrayEquals(a.toArray(), q.dumpList().toArray(), "wrong value");
    }
    // We are testing an iterator
    @Test
    void IteratorTest() {
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        q.enqueue(8);
        q.enqueue(7);
        q.enqueue(14);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(8);
        a.add(7);
        a.add(14);
        ArrayList<Integer> qiter = new ArrayList<Integer>();
        for(Integer iter: q){
            qiter.add(iter);
        }
        assertArrayEquals(a.toArray(), qiter.toArray(), "wrong value");
    }
    // We are testing a reverse iterator
    @Test
    void ReverseIteratorTest() {
        GenericQueue<Integer> q = new GenericQueue<Integer>(3);
        q.enqueue(8);
        q.enqueue(7);
        q.enqueue(14);
        Iterator <Integer> iter = q.descendingIterator();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(14);
        a.add(7);
        a.add(8);
        a.add(3);
        ArrayList<Integer> qiter = new ArrayList<Integer>();
        while(iter.hasNext()){
            qiter.add(iter.next());
        }
        assertArrayEquals(a.toArray(), qiter.toArray(), "wrong value");
    }
}
