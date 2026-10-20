package kerv.bhcc.MyArrayList;


import kerv.bhcc.ArrayException.ArrayException;

public class MyArrayList<E> implements ArrayInterface<E> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 5;

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


    /**
     * Default constructor setting the default capacity to the array.
     * @throws Exception Exception.
     */
    public MyArrayList() throws Exception {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Parametrized constructor, taking the capacity of the array as argument <br>
     * otherwise getting the default capacity from the default constructor.
     * @param capacity Capacity of ArrayList
     * @throws Exception Throws Exception.
     */
    public MyArrayList(final int capacity) throws Exception {
        setElements(capacity);      // initialize the Array
        setCapacity(capacity);      // initialize the capacity
        setSize(0);                 // Initialize the size
    }

    /**
     * Method that resize the array if it is full. <br>
     * 1) Update the capacity by double it. Making the time of complexity 0(1). <br>
     * 2) Creates a tempo array, initialise it with the new capacity.<br>
     * 3) Copy all elements from the array to the tempo array.<br>
     * 4) Point the old array to the new array.
     *
     * @throws ArrayException Exception.
     */
    private void resize() throws ArrayException {
        // Update the array capacity
        setCapacity(getCapacity() * 2);

        // Create a tempo array and initialize it
        Object[] tempArray = new Object[getCapacity()];

        // Copy each data from the old array to the temp array.
        for (int index = 0; index < getSize(); index++) {
            tempArray[index] = elements[index];
        }

        // Point the old array to the temp array
        elements = tempArray;
    }


    /**
     * Method that allow you to add an element to the end of the ArrayList.
     *
     * @param element The element to add to the ArrayList
     */
    @Override
    public void add(E element) throws ArrayException {
        // Check if the array is full
        if (isFull()) {
           resize();   // Resize the array (capacity)]
        }

        // Add the new element to the array
        elements[size++] = element;
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
     *
     * @param capacity
     * @throws ArrayException
     */
    private void setCapacity(int capacity) throws ArrayException {
        if (capacity <= 0)
            throw new ArrayException("Capacity must be greater than 0.");
        this.capacity = capacity;
    }

    /**
     *
     * @param size
     */
    private void setSize(int size) { this.size = size; }

    /**
     *
     * @param capacity
     */
    private void setElements(final int capacity) {
        this.elements = new Object[capacity];
    }

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


    public void print() {
        for(int index = 0; index < getSize(); index++) {
            IO.println(elements[index]);
        }
    }

}
