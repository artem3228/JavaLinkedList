import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Iterator;
public class GSTest {
    // checking add function and length cnt and dumpList function
    @Test
    void addTest1() {
        GenericStack<Integer> s = new GenericStack<>(3);
        s.add(2);
        assertEquals(2, s.getLength(), "wrong value");
        s.add(1);
        assertEquals(3, s.getLength(), "wrong value");
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(2);
        a.add(1);
        assertArrayEquals(a.toArray(), s.dumpList().toArray(), "wrong value");
    }
    // checking pop function and length cnt and dumpList function
    @Test
    void PopTest() {
        GenericStack<Integer> s = new GenericStack<>(3);
        s.add(2);
        s.add(1);
        s.add(0);
        assertEquals(4, s.getLength(), "wrong value");
        s.pop();
        assertEquals(3, s.getLength(), "wrong value");
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(2);
        a.add(1);
        //s.print();
        assertArrayEquals(a.toArray(), s.dumpList().toArray(), "wrong value");
        assertEquals(0, s.getLength(), "wrong value");
        s.add(3);
        s.add(2);
        s.add(1);
        s.pop();
        a.remove(2);
        assertArrayEquals(a.toArray(), s.dumpList().toArray(), "wrong value");
    }
    // Test for an iterator (with using "for each" loop)
    @Test
    void IteratorTest() {
        GenericStack<Integer> s = new GenericStack<>(3);
        assertEquals(1, s.getLength(), "wrong value");
        s.add(8);
        s.add(7);
        s.add(14);
        assertEquals(4, s.getLength(), "wrong value");
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(8);
        a.add(7);
        a.add(14);
        ArrayList<Integer> qiter = new ArrayList<Integer>();
        for(Integer iter: s){
            qiter.add(iter);
        }
        assertArrayEquals(a.toArray(), qiter.toArray(), "wrong value");
    }
    // Test for a reverse iterator
    @Test
    void ReverseIteratorTest() {
        GenericStack<Integer> s = new GenericStack<>(3);
        s.add(8);
        s.add(7);
        s.add(14);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(14);
        a.add(7);
        a.add(8);
        a.add(3);
        ArrayList<Integer> qiter = new ArrayList<Integer>();
        Iterator<Integer> iter = s.descendingIterator();
        while(iter.hasNext()){
            qiter.add(iter.next());
        }
        assertArrayEquals(a.toArray(), qiter.toArray(), "wrong value");
    }
}
