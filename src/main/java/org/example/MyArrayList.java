package org.example;

import java.util.Arrays;

/**
 * @author Oksana Borisenko
 *
 * Purpose: to create a ArrayList implementation
 */

public class MyArrayList<T> implements MyList<T> {

    /** array of the objects */
    private T [] array;

    /** default array size */
    private final static int INIT_SIZE = 10;

    /** Allow you to see how many times the size of the array increases */
    private final static int INCREASING_SIZE_ARRAY = 2;

    /** The current amount of elements in the arrayList array */
    private int countElementsOfArray;

    /**
     * The default constructor that creates an arrayList with a default size of 10
     * */
    public MyArrayList() {
        Object [] arr = new Object[INIT_SIZE];
        this.array = (T[]) arr ;
        this.countElementsOfArray = 0;
    }

    /**
     * Constructor with initial size the array.
     * Precondition: Parameter initialCapacity must be larger than 0.
     * Postcondition: The constructor initializes the arrayList data field with size initialCapacity.
     * @param initialCapacity initial capacity of the array
     */
    public MyArrayList(int initialCapacity) {
        if(initialCapacity <= 0 ){
            System.out.println("The size of the arrayList must be greater than 0. Try again.");
            return;
        }
        Object [] arr = new Object[initialCapacity];
        this.array = (T[]) arr ;
        this.countElementsOfArray = 0;
    }

    /**
     * Allows you to get the count of elements in the Arraylist.
     * @return countElementsOfArray value.
     */
    @Override
    public int sizeList(){
        return this.countElementsOfArray;
    }

    /**
     * Allows you to see if the array is empty.
     * @return boolean
     */
    @Override
    public boolean isEmpty(){
        return this.countElementsOfArray == 0;
    }

    /**
     * Method returns the location of first occurrence of an object.
     * Precondition: Must pass a parameter of type Object.
     * Postcondition: Checks to see if the arrayList contains the Object object.
     * If it does, the position of the Object is returned. Otherwise, -1 is returned.
     * @param object The Object that the method will search for in arrayList
     * @return position of the object within the arrayList (.
     */
    @Override
    public int get(T object){
        int position = -1;
        for(int i = 0; i < this.array.length; i++){
            if(object.equals(this.array[i])){
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     * A method allow to see if a particular object exist in the arrayList.
     * @param object The object that the user checks to see if it's in the arrayList.
     * @return boolean True if object exists, otherwise, false .
     */
    @Override
    public boolean isExists(T object){
        return get(object) >= 0;
    }

    /**
     * A method allows you to remove all elements from the arrayList.
     */
    @Override
    public void removeAll() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /**
     * A method removes the first occurence of an object in the arrayList.
     * @param object The object to be removed from the arrayList.
     */
    @Override
    public void remove(T object){
        if(get(object) >= 0){
            this.array[get(object)] = null;
            this.countElementsOfArray--;
        }
    }

    /**
     * A method that allows you to write an Object at the end of the ArrayList.
     * @param object the object to be added to the arrayList array.
     */
    @Override
    public void add(T object){
        if(checkIfArrayFull()){
            copyArray();
        }
        this.array[this.countElementsOfArray] = object;
        this.countElementsOfArray++;
    }

    /**
     * A method that allows you to write an Object at the given location of the ArrayList.
     * @param object the object to be added to the arrayList array.
     * @param index the object will be added to arrayList at the index.
     */
    public void add(int index, T object){
        if(index >= this.array.length || index < 0){
            System.out.println("The index is out of bounds from arrayList. Try again.");
            return;
        }

        if(checkIfArrayFull()){
            copyArray();
            changeElementsLocation(index, object);
        }else {
            changeElementsLocation(index, object);
            this.countElementsOfArray++;
        }
    }

    /**
     * A method that allows you to change location elements of the ArrayList.
     * @param object the object to be added to the arrayList array.
     * @param index the object will be added to arrayList at the index.
     */
    private void changeElementsLocation(int index, T object) {
        T curr = this.array[index];
        array[index] = object;

        T curr2;

        for(int i = index; i < this.array.length - 1; i ++){
            curr2 = array[i + 1];
            array[i+1] = curr;
            curr = curr2;
        }
    }

    /**
     * Checks to see if the array is full.
     * @return boolean
     */
    private boolean checkIfArrayFull(){
        return this.array.length == this.countElementsOfArray;
    }

    /**
     * The method allow to copy the current array to the larger newArray.
     * */
    private void copyArray(){
        Object[] newArray = new Object[this.array.length*INCREASING_SIZE_ARRAY];
        int countElementsOfNewArray = 0;
        for(int i = 0; i < this.array.length; i++, countElementsOfNewArray++){
            newArray[i] = this.array[i];
        }
        this.array = (T[]) newArray;
    }

    @Override
    public String toString() {
        return "Elements of ArrayList: " + Arrays.toString(array);
    }
}
