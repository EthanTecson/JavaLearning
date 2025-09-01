package miniCollections.src.java;

public class MiniLinkedList<E> extends MiniCollection<E> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        E data;
        Node next;
        Node (E data) { this.data = data; }
    }

    // Append to end
    public void add(E e){
        Node newNode = new Node(e);
        newNode.data = e;
        tail.next = newNode;
        tail = newNode;
    }

    // Append at specific index
    public void add(int index, E e){
        Node newNode = new Node(e);
        newNode.data = e;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        int count = 0;
        Node mainPtr = head;
        Node prevPtr = null;
        while (count != index) {
            prevPtr = mainPtr;
            mainPtr = mainPtr.next;
            count++;
        }
        newNode.next = mainPtr;
        prevPtr.next = newNode;
        return;
    }

    // Get element at specific index
    public E get(int index){
        if (index < 0) {
            System.out.println("Index must be great than zero");
            return null;
        }

        if (index >= size) {
            System.out.println("Index out of range");
            return null;
        }

        int count = 0;
        Node ptr = head;
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

        if (index >= size) {
            System.out.println("Index out of range");
            return;
        }

        int count = 0;
        Node ptr = head;
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

        if (index >= size) {
            System.out.println("Index out of range");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        int count = 0;
        Node prevPtr = null;
        Node mainPtr = head;
        while (count != index) {
            prevPtr = mainPtr;
            mainPtr = mainPtr.next;
        }
        prevPtr.next = mainPtr.next;
        return;
    }

    public int indexOf(Object o){
        return 1;
    }

    public boolean containts(Object o){
        return false;
    }


    // miniCollection Implementation
    protected int size(){
        return 0;
    }

    protected boolean isEmpty(){
        return false;
    }

    protected void clear(){
        return;
    }

    private class LinkedListIterator implements MiniIterator<E>{
        public boolean hasNext() {
            return false;
        }

        public E next() {
            Node result = null;
            return result.data;
        }
    }

    protected MiniIterator<E> iterator() {
        return new LinkedListIterator();
    }
}