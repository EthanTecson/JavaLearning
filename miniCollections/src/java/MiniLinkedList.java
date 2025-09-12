package miniCollections.src.java;

import java.util.NoSuchElementException;

public class MiniLinkedList<E> extends MiniCollection<E> {

    private Node HEAD;
    private int SIZE;

    private class Node {
        E data;
        Node next;
        Node (E data) { this.data = data; }
    }

    // Append to end
    public void add(E e){
        Node newNode = new Node(e);
        newNode.data = e;
        SIZE++;
    }

    // Append at specific index
    public void add(int index, E e){
        Node newNode = new Node(e);
        newNode.data = e;

        if (index == 0) {
            newNode.next = HEAD;
            HEAD = newNode;
            return;
        }

        int count = 0;
        Node mainPtr = HEAD;
        Node prevPtr = null;
        while (count != index) {
            prevPtr = mainPtr;
            mainPtr = mainPtr.next;
            count++;
        }
        newNode.next = mainPtr;
        prevPtr.next = newNode;
        SIZE++;
        return;
    }

    // Get element at specific index
    public E get(int index){
        if (index < 0) {
            System.out.println("Index must be great than zero");
            return null;
        }

        if (index >= SIZE) {
            System.out.println("Index out of range");
            return null;
        }

        int count = 0;
        Node ptr = HEAD;
        while (count != index) {
            ptr = ptr.next;
        }
        return ptr.data;
    }

    public void set(int index, E e){
        if (index < 0) {
            System.out.println("Index must be great than zero");
            return;
        }

        if (index >= SIZE) {
            System.out.println("Index out of range");
            return;
        }

        int count = 0;
        Node ptr = HEAD;
        while (count != index) {
            ptr = ptr.next;
        }
        ptr.data = e;

        System.out.println("Node at Index " + index + "set to " + e);
    }

    public void remove(int index){
        if (index < 0) {
            System.out.println("Index must be great than zero");
            return;
        }

        if (index >= SIZE) {
            System.out.println("Index out of range");
            return;
        }

        if (index == 0) {
            HEAD = HEAD.next;
            return;
        }

        int count = 0;
        Node prevPtr = null;
        Node mainPtr = HEAD;
        while (count != index) {
            prevPtr = mainPtr;
            mainPtr = mainPtr.next;
        }
        prevPtr.next = mainPtr.next;
        SIZE--;
        return;
    }

    public int indexOf(Object o){
        Node ptr = HEAD;
        int count = 0;
        while (ptr != o) {
            ptr = ptr.next;
            count++;
        }
        return count;
    }

    public boolean containts(Object o){
        Node ptr = HEAD;
        while (ptr.next != null) {
            if (ptr == o) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }


    // miniCollection Implementation
    protected int size(){
        if (HEAD == null) {
            return 0;
        }

        return SIZE; 
    }

    protected boolean isEmpty(){
        if (HEAD == null){
            return true;
        }
        return false;
    }

    protected void clear(){
        HEAD = null;
        return;
    }

    private class LinkedListIterator implements MiniIterator<E>{
        private Node current = HEAD;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    protected MiniIterator<E> iterator() {
        return new LinkedListIterator();
    }
}