package miniCollections.src.java;

public class MiniLinkedList<E> extends MiniCollection<E> {
    private class Node<E> {
        E data;
        Node<E> next;
    }
    // Append to end
    void add(E e){
        ;
    }
    // Append at specific index
    void add(int index, E e){
        ;
    }
    // Get element at specific index
    E get(int index){
        Node<E> result = null;
        return result.data;
    }

    E set(int index, E e){
        Node<E> result = null;
        result.data = e;
        return result.data;
    }

    E remove(int index){
        Node<E> result = null;
        return result.data;
    }

    int indexOf(Object o){
        return 1;
    }

    boolean containts(Object o){
        return false;
    }
}