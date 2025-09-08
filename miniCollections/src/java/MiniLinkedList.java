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
        Node ptr = head;
        int count = 0;
        while (ptr != o) {
            ptr = ptr.next;
            count++;
        }
        return count;
    }

    public boolean containts(Object o){
        Node ptr = head;
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
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            count += 1;
        }

        return count; 
    }

    protected boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }

    protected void clear(){
        head = null;
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