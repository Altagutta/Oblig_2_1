import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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
        assertEquals(new Integer[] {4,3,2,1} ,ints.toArray());
    }

    @Test
    public void listIteratorAddMethod() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.add(3);
        listIterator = defaultIntList.listIterator();
        ArrayList<Integer> ints = new ArrayList<>();
        while(listIterator.hasNext()) {
            Integer i = listIterator.next();
            ints.add(i);
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

    @Test
    public void listIteratorAddAndRemoveCombined() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.remove();
        listIterator.remove();
        listIterator.add(1);
        listIterator.add(2);
        listIterator.remove();
        listIterator.next();
        listIterator.remove();
        ArrayList<Integer> ints = new ArrayList<>();
        listIterator = defaultIntList.listIterator();
        while(listIterator.hasNext()) {
            ints.add(listIterator.next());
        }
        assertEquals(new Integer[] {1,2,4} ,ints.toArray());
    }

    @Test
    public void nextIndexMethod() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.next();
        assertEquals(2, listIterator.nextIndex());
    }

    @Test
    public void previousIndexMethod() {
        ListIterator<Integer> listIterator = defaultIntList.listIterator();
        listIterator.next();
        assertEquals(0, listIterator.previousIndex());
    }

    @Test
    public void standardIterator() {
        Iterator<Integer> iterator = defaultIntList.iterator();
        ArrayList<Integer> ints = new ArrayList<>();
        while(iterator.hasNext()) {
            ints.add(iterator.next());
        }
        assertEquals(new Integer[] {1,2,3,4,5} ,ints.toArray());
    }

    // </ANDREAS>

}
