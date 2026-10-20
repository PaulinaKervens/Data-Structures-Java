package kerv.bhcc.MyArrayList;

public class MyArrayList<E> implements ArrayInterface<E> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Attribute for the ArrayList which is a static allocated array
     */
    private Object[] elements;

    /**
     * Attribute that store ArrayList size
     */
    private int size;

    /**
     * Attribute that store ArrayList capacity
     */
    private int capacity;






    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(final int capacity) {
        elements = new Object[capacity];
        setCapacity(capacity);
    }


    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Method that allow you to add an element to the end of the ArrayList.
     *
     * @param element The element to add to the ArrayList
     */
    @Override
    public void add(E element) {

    }

    /**
     * Method that add an E element to a specific place.
     *
     * @param index   The place where to add that element.
     * @param element The element to add to the ArrayList.
     */
    @Override
    public void add(int index, E element) {

    }

    /**
     * Method to replaces an element at a specific index.
     * @param index The target.
     * @param e The new element.
     */
    public E set(int index, E e) {
        return null;
    }

    /**
     * Method to removes an element at an index.
     *
     * @param index the place where the element is located.
     * @return True or False, if the element has been removed.
     */
    @Override
    public boolean remove(int index) {
        return false;
    }


    /**
     * Method that removes the first matching element.
     *
     * @param o
     * @return True or False, if the element has been removed.
     */
    @Override
    public boolean removeMatched(Object o) {
        return false;
    }

    /**
     * Method that removes the last element.
     *
     * @return True or False, if the element has been removed.
     */
    @Override
    public boolean removeLast() {
        return false;
    }

    /**
     * Method that Checks whether an element exists in the ArrayList.
     *
     * @param o The element target.
     * @return True or False
     */
    @Override
    public Boolean contains(Object o) {
        return null;
    }

    /**
     * Returns the first matching index, or -1.
     *
     * @param o
     */
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * Returns the last matching index, or -1.
     *
     * @param o
     * @return
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * Method that get and return an element at a specific location.
     *
     * @param index The element location.
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Method that retrieve and display the last element of the ArrayList.
     *
     * @return An E type of the element list.
     */
    @Override
    public E getLast() {
        return null;
    }

    /**
     * Method that check if the ArrayList is Empty.
     *
     * @return True or False.
     */
    @Override
    public Boolean isEmpty() { return getSize() == 0; }

    /**
     * Method that check if the ArrayList is full.
     *
     * @return True or False.
     */
    @Override
    public Boolean isFull() { return getSize() == getCapacity(); }

    /**
     * Method to get the ArrayList size
     */
    @Override
    public int getSize() { return size; }

    /**
     * Method to get the ArrayList capacity
     */
    @Override
    public int getCapacity() { return capacity; }
}
