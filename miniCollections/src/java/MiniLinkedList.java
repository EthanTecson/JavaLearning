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
        ;
    }
    // Get element at specific index
    public E get(int index){
        Node result = null;
        return result.data;
    }

    public E set(int index, E e){
        Node result = null;
        result.data = e;
        return result.data;
    }

    public E remove(int index){
        Node result = null;
        return result.data;
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