package miniCollections.src.java;

abstract class MiniCollection<E>{
    protected abstract int size();
    protected abstract boolean isEmpty();
    protected abstract void clear();
    protected abstract MiniIterator<E> iterator();
}
