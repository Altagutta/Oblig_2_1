import java.util.Iterator;
        import java.util.ListIterator;
import java.util.NoSuchElementException;

// MERK:
// Alle metoder som tar inn en index skal kaste indexoutofbound exception
//
public class DoublyLinkedList<E> implements MyList<E> {
    // Datamedlemmer
    private Node<E> first, last;
    private int size = 0;

    /** Create a default list */
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /** Create a list from an array of objects */
    public DoublyLinkedList(E[] objects) {}

    /** Return the head element in the list */
    public E getFirst() {}

    /** Return the last element in the list */
    public E getLast() {}

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {}

    /** Add an element to the end of the list */
    public void addLast(E e) {
        
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E e) {

    }
    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    //  <FREDIK\>
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> tmp = first;
        first = first.next;
        first.previous = null;
        size--;
        return tmp.element;
    }
    /**
     * Remove the last node and return the object that is contained in the
     * removed node.
     */
    public E removeLast() {

        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> tmp = last;
        last = last.next;
        last.previous = null;
        size--;
        return tmp.element;

    }
    //  </FREDRIK>

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    public E remove(int index) {

    }

    @Override
    public String toString() {}

    /** Clear the list */
    public void clear() {}

    /** Return true if this list contains the element o */
    public boolean contains(Object e) {}

    /** Return the element from this list at the specified index */
    public E get(int index) {
        return null;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    public int indexOf(Object e) {}

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     */
    public int lastIndexOf(Object e) {}

    /**
     * Replace the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E e) {}

    @Override
    public int size() {
        return size;
    }


    public ListIterator<E> listIterator() {}

    public ListIterator<E> listIterator(int index) {}

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}