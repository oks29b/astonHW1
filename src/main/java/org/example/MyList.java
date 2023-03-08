package org.example;

/**
 * @author Oksana Borisenko
 *
 * Purpose: to create a ArrayList implementation
 */
public interface MyList<T> {
    void add(T object);
    int get(T object);
    void remove(T object);
    boolean isEmpty();
    int sizeList();
    boolean isExists(T object);
    void removeAll();

    //TODO:
//    void sort(Comparator<? super T> c);
}
