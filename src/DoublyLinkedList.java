import java.util.Iterator;
        import java.util.ListIterator;
import java.util.NoSuchElementException;

// MERK:
// Alle metoder som tar inn en index skal kaste indexoutofbound exception
//
public class DoublyLinkedList<E> implements MyList<E> {
    //  <SEVERIN>
    private Node<E> first, last;
    private int size = 0;
    //  </SEVERIN>

    /** Create a default list */
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    /** Create a list from an array of objects */
    public DoublyLinkedList(E[] objects) {

    }

    //  <SEVERIN>
    /** Return the head element in the list */
    public E getFirst() {
        if(size == 0) {
            return null;
        }
        return first.element;
    }

    /** Return the last element in the list */
    public E getLast() {
        if(size == 0) {
            return null;
        }
        return last.element;
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = first;
        first.previous = newNode;
        first = newNode;
        size++;

        if (last == null) { last = first; }
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = first;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            temp.previous = current.next;
            (current.next).previous = current;
            size++;
        }
    }
    //  </SEVERIN>

    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    //  <FREDIK>
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
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> tmp = first;
        for (int  i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
        return tmp.element;
    }
    //  </FREDRIK>

    //  <SEVERIN>
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            } else {
                result.append("]");
            }
        }
        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        size = 0;
        first = last = null;
    }

    /** Return true if this list contains the element o */
    public boolean contains(Object e) {
        ListIterator<E> listIterator = listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next() == e) {
                return true;
            }
        }
        return false;
    }

    /** Return the element from this list at the specified index */
    public E get(int index) throws IndexOutOfBoundsException {
        ListIterator<E> listIterator = listIterator();
        while(listIterator.hasNext()) {
           if(listIterator.nextIndex() == index) {
               return listIterator.next();
           }
        }
        return null;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    public int indexOf(Object e) {
        ListIterator<E> listIterator = listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next() == e) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     */
    public int lastIndexOf(Object e) {
        ListIterator<E> listIterator = listIterator(size - 1);
        while(listIterator.hasPrevious()) {
            if(listIterator.previous() == e) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    /**
     * Replace the element at the specified position in this list with the
     * specified element. Returns the old element.
     */
    public E set(int index, E e) throws IndexOutOfBoundsException {
        ListIterator<E> listIterator = listIterator(index);
        E old = listIterator.next();
        listIterator.previous();
        listIterator.set(e);
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);
    }
    // </SEVERIN>

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    //  <ANDREAS>
    private class LinkedListIterator implements java.util.ListIterator<E> {
        private Node<E> current;
        private int index;

        public LinkedListIterator() {
            current = first;
            index = 0;
        }

        public LinkedListIterator(int index) {
            this();
            for(int i = 0; i < index; i++) {
                if(hasNext()) {
                    current = current.next;
                    continue;
                }
                throw new NoSuchElementException();
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(hasNext()) {
                E e = current.element;
                current = current.next;
                index++;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return current.previous != null;
        }

        @Override
        public E previous() {
            if(hasPrevious()) {
                E e = current.previous.element;
                current = current.previous;
                index--;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            return index+1;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            if(current != null) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current = current.next;
                index--;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void set(E e) {
            current.element = e;
        }

        @Override
        public void add(E e) {
            Node<E> node = new Node<>(e);
            node.previous = current.previous;
            current.previous.next = node;
            node.next = current;
            current.next.previous = node;
            index++;
        }
    }
    //  </ANDREAS>
}