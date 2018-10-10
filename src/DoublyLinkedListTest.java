import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    //  <ANDREAS>
    static DoublyLinkedList<Integer> defaultIntList;

    @Before
    public void initStaticList() {
        defaultIntList = new DoublyLinkedList<>(new Integer[]{1, 2, 3, 4, 5});
    }

    @Test
    public void noargConstructor() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertNotNull(list);
    }

    @Test
    public void createFromListConstructor() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>(new String[]{"Alpha", "Bravo", "Charlie", "Delta", "Echo"});
        assertEquals("Alpha, Bravo, Charlie, Delta, Echo", list.toString());
    }

    @Test
    public void getFirstMethod() {
        assertTrue(new Integer(1).equals(defaultIntList.getFirst()));
    }

    @Test
    public void getLastMethod() {
        assertTrue(new Integer(5).equals(defaultIntList.getLast()));
    }

    @Test
    public void getMethod() {
        assertTrue(new Integer(3).equals(defaultIntList.get(2)));
    }

    @Test
    public void addFirstMethod() {
        defaultIntList.addFirst(3);
        assertEquals("3, 1, 2, 3, 4, 5", defaultIntList.toString());
    }

    @Test
    public void addLastMethod() {
        defaultIntList.addLast(3);
        assertEquals("1, 2, 3, 4, 5, 3", defaultIntList.toString());
    }

    @Test
    public void addMethod() {
        defaultIntList.add(3, 1);
        assertEquals("1, 2, 3, 1, 4, 5", defaultIntList.toString());
    }

    @Test
    public void removeFirstMethod() {
        int removed = defaultIntList.removeFirst();
        assertEquals("Does not return array in specified order" ,"2, 3, 4, 5", defaultIntList.toString());
        assertEquals("Does not return same object" ,1 ,removed);
    }

    @Test
    public void removeLastMethod() {
        int removed = defaultIntList.removeLast();
        assertEquals("Does not return array in specified order" ,"1, 2, 3, 4", defaultIntList.toString());
        assertEquals("Does not return same object" ,1 ,removed);
    }

    @Test
    public void removeMethod() {
        int removed = defaultIntList.remove(3);
        assertEquals("Does not return array in specified order" ,"1, 2, 3, 5", defaultIntList.toString());
        assertEquals("Does not return same object" ,1 ,removed);
    }

    @Test
    public void toStringMethod() {
        assertEquals("1, 2, 3, 4, 5", defaultIntList.toString());
    }

    @Test
    public void clearMethod() {
        defaultIntList.clear();
        assertEquals("", defaultIntList.toString());
    }

    @Test
    public void containsMethodTrue() {
        assertEquals(true, defaultIntList.contains(3));
    }

    @Test
    public void containsMethodFalse() {
        assertEquals(false, defaultIntList.contains(6));
    }

    @Test
    public void indexOfMethod() {
        assertEquals(2, defaultIntList.indexOf(3));
    }

    @Test
    public void lastIndexOfMethod() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(new Integer[]{1, 2, 3, 4, 5, 3, 3});
        assertEquals(6, list.lastIndexOf(3));
    }

    @Test
    public void setMethod() {
        defaultIntList.set(3, 1000);
        assertEquals("1, 2, 3, 1000, 5", defaultIntList.toString());
    }

    @Test
    public void sizeMethod() {
        assertEquals(5 ,defaultIntList.size());
    }

    //  </ANDREAS>

}
