import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.assertEquals;

public class LinkedListIteratorTest {
    //  <ANDREAS>

    static DoublyLinkedList<Integer> defaultIntList;

    @Before
    public void initStaticList() {
        defaultIntList = new DoublyLinkedList<>(new Integer[]{1, 2, 3, 4, 5});
    }

    //Tests iterator.next, and by extension default no-arg constructor
    @Test
    public void listIteratorNext() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        ArrayList<Integer> ints = new ArrayList<>();
        while(listIterator.hasNext()) {
            ints.add(listIterator.next());
        }
        assertEquals(new Integer[] {1,2,3,4,5} ,ints.toArray());
    }

    //Tests iterator.previous(), and the constructor with index as argument
    @Test
    public void listIteratorPrevious() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator(defaultIntList.size()-1);
        ArrayList<Integer> ints = new ArrayList<>();
        while(listIterator.hasPrevious()) {
            ints.add(listIterator.previous());
        }
        assertEquals(new Integer[] {5,4,3,2,1} ,ints.toArray());
    }

    @Test
    public void listIteratorAddMethod() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.add(3);
        ArrayList<Integer> ints = new ArrayList<>();
        while(listIterator.hasNext()) {
            ints.add(listIterator.next());
        }
        assertEquals(new Integer[] {3,1,2,3,4,5} ,ints.toArray());
    }

    @Test
    public void listIteratorRemoveMethod() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.remove();
        ArrayList<Integer> ints = new ArrayList<>();
        while(listIterator.hasNext()) {
            ints.add(listIterator.next());
        }
        assertEquals(new Integer[] {2,3,4,5} ,ints.toArray());
    }

    @Test
    public void listIteratorSetMethod() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.set(3);
        ArrayList<Integer> ints = new ArrayList<>();
        while(listIterator.hasNext()) {
            ints.add(listIterator.next());
        }
        assertEquals(new Integer[] {3,2,3,4,5} ,ints.toArray());
    }

    // </ANDREAS>

}
