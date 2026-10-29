package kerv.bhcc.MyArrayList;


import kerv.bhcc.ArrayException.ArrayException;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyArrayList<E> implements ArrayInterface<E>, Iterable<E> {

    /**
     * The default initial capacity of this stack.
     */
    private static final int DEFAULT_CAPACITY = 5;

    /**
     * The array buffer into which the elements of the stack are stored.
     */
    private Object[] elements;

    /**
     * The current number of elements contained in this stack.
     */
    private int size;

    /**
     * The maximum capacity of this stack.
     */
    private int capacity;


    /**
     * Constructs a new collection with a default initial capacity.
     *
     * @throws ArrayException if an error occurs during initialization
     */
    public MyArrayList() throws ArrayException {
        this(DEFAULT_CAPACITY);
    }


    /**
     * Constructs a new collection with the specified initial capacity.
     *
     * @param capacity the initial capacity of the collection
     * @throws ArrayException if the specified capacity is less than or equal to 0
     */
    public MyArrayList(final int capacity) throws ArrayException {
        setElements(capacity); // Initialize the underlying array
        setCapacity(capacity); // Initialize and validate the capacity
        setSize(0);            // Initialize the size
    }


    /**
     * Resizes the underlying array when the stack is full by doubling its capacity. <br>
     * 1) Update the capacity by double it. Making the time of complexity 0(1). <br>
     * 2) Creates a tempo array, initialise it with the new capacity.<br>
     * 3) Copy all elements from the array to the tempo array.<br>
     * 4) Point the old array to the new array.
     *
     * @throws ArrayException ArrayException if the new capacity is invalid
     */
    private void resize() throws ArrayException {
        // Update the array capacity by doubling it
        setCapacity(capacity * 2);

        // Create a temporary array and initialize it with the new capacity
        Object[] tempArray = new Object[capacity];

        // Copy all elements from the old array to the temporary array
        for (int index = 0; index < getSize(); index++) {
            tempArray[index] = elements[index];
        }

        // Point the old array reference to the temporary array
        elements = tempArray;
    }


    /**
     * Appends the specified element to the end of this stack.
     * If the stack is full, it automatically resizes before adding.
     *
     * @param element the element to be added
     * @throws ArrayException if an error occurs while resizing the stack
     */
    @Override
    public void add(E element) throws ArrayException {
        // Check if the array is full and resize if necessary
        if (isFull()) {
            resize();
        }

        // Add the new element to the stack and increment the size
        elements[size++] = element;
    }


    /**
     * Inserts the specified element at the specified position in this stack.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right.
     *
     * @param index the index at which the specified element is to be inserted
     * @param element the element to be inserted
     * @throws ArrayException if an error occurs while resizing the stack
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void add(int index, E element) throws ArrayException {
        // Validate the index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Check if the stack is full and resize if necessary
        if (isFull()) {
            resize();
        }

        // Shift elements to the right to make space for the new element
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        // Insert the element at the specified index and increment the size
        elements[index] = element;
        size++;
    }


    /**
     * Replaces the element at the specified position in this stack with the specified element.
     *
     * @param index the index of the element to replace
     * @param e the element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        // Check if the index is outside the logical size
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getSize());
        }

        // Store the old data from the index
        Object oldData = elements[index];

        // Update the element at the specified index
        elements[index] = e;

        // Return the old data
        return (E) oldData;
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
        // Check if the array list is not empty
        if (!isEmpty()) {
            // Update the last element to null
            // to clear the reference to the last element.
            elements[getSize() - 1] = null;
            // Decreases the logical size by one.
            setSize(getSize() - 1);
            return true;    // Returns true when removal succeeds.
        }

        // Returns false when the list is already empty
        return false;
    }


    /**
     * Returns {@code true} if this stack contains the specified element.
     *
     * @param o the element whose presence in this stack is to be tested
     * @return {@code true} if this stack contains the specified element; {@code false} otherwise
     * @throws ArrayException if an error occurs while checking containment
     */
    @Override
    public boolean contains(final Object o) throws ArrayException {
        // Search through the valid elements in the stack
        for (int index = 0; index < getSize(); index++) {
            // Check if the current element matches the target object
            if (java.util.Objects.equals(elements[index], o)) {
                return true;
            }
        }

        // Return false if the element is not found
        return false;
    }


    /**
     * Returns the index of the first occurrence of the specified element
     * in this stack, or -1 if this stack does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element, or -1 if not found
     */
    @Override
    public int indexOf(Object o) {
        // Check if the stack is empty or the target object is null
        if (isEmpty() || o == null) {
            return -1;
        }

        // Search through the valid elements in the stack
        for (int index = 0; index < getSize(); index++) {
            // Check if that current element match the target
            if (java.util.Objects.equals(elements[index], o)) {
                return index; // Return the 0-based index
            }
        }

        // Return -1 if the element is not found
        return -1;
    }


    /**
     * Compares element e with the elements in the array, <br>
     * starting from the last one. <br>
     * If a match is found, the index of the element is returned; <br>
     * Otherwise, −1 is returned.
     *
     * @param o
     * @return
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }


    /**
     * Returns the element at the specified position in this stack.
     * <p>
     * Time complexity is O(1).
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this stack
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        // Check if the index is outside the logical size
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getSize());
        }

        // Return the element at the requested index
        return (E) elements[index];
    }


    /**
     * Returns the last element in this stack.
     *
     * @return the last element in this stack
     * @throws NoSuchElementException if this stack is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public E getLast() {
        // Check if the stack is empty before retrieving
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty.");
        }

        // Return the last value of the array
        return (E) elements[getSize() - 1];
    }


    /**
     * Returns the first element in this stack.
     *
     * @return the first element in this stack
     * @throws NoSuchElementException if this stack is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public E getFirst() {
        // Check if the stack is empty before retrieving
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty.");
        }

        // Return the first element of the array
        return (E) elements[0];
    }


    /**
     * Checks if this stack is empty.
     *
     * @return {@code true} if this stack is empty; {@code false} otherwise
     */
    @Override
    public Boolean isEmpty() {
        return getSize() == 0;
    }


    /**
     * Checks if this stack is full.
     *
     * @return {@code true} if this stack is full; {@code false} otherwise
     */
    @Override
    public Boolean isFull() {
        return getSize() == capacity;
    }


    /**
     * Sets the maximum capacity of this stack.
     *
     * @param capacity the new capacity to set
     * @throws ArrayException if the specified capacity is less than or equal to 0
     */
    private void setCapacity(int capacity) throws ArrayException {
        if (capacity < 1)
            throw new ArrayException("Capacity must be greater than 0.");
        this.capacity = capacity;
    }


    /**
     * Sets the current size of this stack.
     *
     * @param size the new size to set
     */
    private void setSize(int size) {
        this.size = size;
    }


    /**
     * Initializes or updates the underlying array with the specified capacity.
     *
     * @param capacity the maximum capacity for the underlying array
     */
    private void setElements(final int capacity) {
        // Check the capacity range
        if (capacity < 1)
            throw new RuntimeException("Capacity cannot be a negative number..");
        this.elements = new Object[capacity];
    }


    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    @Override
    public int getSize() {
        return size;
    }


    /**
     * Removes all elements from the stack and resets its capacity to the default capacity.
     *
     * @throws ArrayException if an error occurs while clearing the stack
     */
    @Override
    public void clear() throws ArrayException {
        elements = new Object[DEFAULT_CAPACITY];
        setCapacity(DEFAULT_CAPACITY);
        setSize(0);
    }


    public void print() {
        if (isEmpty())
            IO.println("Empty array");


        for(int index = 0; index < getSize(); index++) {
            IO.println(elements[index]);
        }
    }

    /**
     * Returns an iterator over the elements in this stack in proper sequence.
     *
     * @return an iterator over the elements in this stack in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            // Index of the next element to return
            private int current = 0;

            /**
             * Returns {@code true} if the iteration has more elements.
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return current < getSize();
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws java.util.NoSuchElementException if the iteration has no more elements
             */
            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("No more elements in the stack.");
                }
                // Return the current element and then advance the pointer
                return (E) elements[current++];
            }
        };
    }


}
