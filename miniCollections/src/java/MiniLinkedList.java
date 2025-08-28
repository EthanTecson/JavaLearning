package miniCollections.src.java;

public class MiniLinkedList<E> extends MiniCollection<E> {
    private class Node<E> {
        E data;
        Node<E> next;
    }
    // Append to end
    public void add(E e){
        ;
    }
    // Append at specific index
    public void add(int index, E e){
        ;
    }
    // Get element at specific index
    public E get(int index){
        Node<E> result = null;
        return result.data;
    }

    public E set(int index, E e){
        Node<E> result = null;
        result.data = e;
        return result.data;
    }

    public E remove(int index){
        Node<E> result = null;
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
            Node<E> result = null;
            return result.data;
        }
    }

    protected MiniIterator<E> iterator() {
        return new LinkedListIterator();
    }
}