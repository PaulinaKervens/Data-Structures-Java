/**
 * A custom generic stack implementation providing standard LIFO operations,
 * capacity management, and iteration support.
 *
 * @param <T> the type of elements held in this stack
 * @author Kervens Paulina
 * @see java.util.Stack
 */

package MyStack.src.kerv.MyStack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Stack class.
 * Last-In, First-Out (LIFO) data structure.
 * @param <T> A generic type.
 */
public class MyStack<T> implements MyStackInterface<T>, Iterable<T>  {

    /**
     * Attribute to keep track the top of the stack.
     */
    private int top;

    /**
     * Attribute to set the stack capacity.
     */
    private int capacity;

    /**
     * The array stack.
     */
    private T[] elements;


    /**
     * Default constructor.
     */
    public MyStack() {
        this(10);
    }


    /**
     * Constructs a new stack with the specified capacity.
     *
     * @param capa the stack capacity.
     */
    public MyStack(int capa) {
        this.setCapacity(capa);
        this.setTop(-1);
        this.setElements(capa);
    }


    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto the stack
     * @return the item argument
     * @throws StackOverflowError if the stack is full
     */
    public T push(T item) {
        // Add the element to the stack array
        if (!addElement(item))
            throw new StackOverflowError("The stack is full, remove an item before pushing...");

        // Return the item argument
        return item;
    }


    /**
     * Inserts an element into the stack.
     *
     * @param item the element to insert
     * @return true if the element has been added; otherwise false
     */
    private boolean addElement(T item) {
        // Check if the stack is full or the item is null
        if (isFull() || item == null)
            return false;

        // Add the element to the top
        elements[++top] = item;

        // return true
        return true;
    }


    /**
     * Removes and returns the top element from this stack.
     *
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        // Check if the stack is empty
        if (isEmpty())
            throw new EmptyStackException();

        // Return and remove the top element
        return elements[top--];
    }


    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return the object at the top of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public T peek() {
        // Check if stack is not empty
        if (isEmpty())
            throw new NoSuchElementException("The stack is empty");
        // Return the top element
        return elements[top];
    }


    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        return top == capacity - 1;
    }



    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * Initializes the elements array by reserving the specified capacity.
     *
     * @param size The initial capacity to reserve for the elements array.
     */
    @SuppressWarnings("Unchecked")
    private void setElements(int size) {
        this.elements = (T[]) new Object[size];
    }


    /**
     * Sets the top value.
     *
     * @param top the new value for the top attribute
     */
    private void setTop(int top) {
        this.top = top;
    }


    /**
     * Sets the capacity.
     *
     * @param capacity the new capacity value (must be at least 1)
     * @throws IllegalArgumentException if capacity is less than 1
     */
    private void setCapacity(int capacity) {
        // Throw an Exception for a negative capacity.
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity must be at least 1");
        this.capacity = capacity;
    }


    /**
     * Returns an array containing all the elements in this stack in proper sequence.
     *
     * @return an array containing the elements of the stack
     */
    @SuppressWarnings("Unchecked")
    public T[] toArray() {
        // Create a new array of the same type and capacity
        T[] array = (T[]) new Object[top + 1];

        // Copy elements from the stack array up to the current top
        for (int i = 0; i <= top; i++) {
            array[i] = elements[i];
        }

        // return the array
        return array;
    }



    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator over the elements in the stack
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // Tracks the current position during iteration
            private int current = -1;

            @Override
            public boolean hasNext() {
                return current < top;
            }

            @Override
            public T next() {
                // Throw an exception if we are at the end of the stack
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                // Return the next element
                return elements[++current];
            }
        };
    }

    /**
     * Searches for the specified object in this stack.
     *
     * @param o the object to look for
     * @return the 1-based position of the object from the bottom, or -1 if not found
     */
    public int search(Object o) {
        // Check if the stack is empty or the target object is null
        if (isEmpty() || o == null)
            return -1;

        // Local variable to get track the target position
        int position = 0;

        for (int index = 0; index <= top; index++) {
            // Increment position
            position++;
            if (o.equals(elements[index])) {
                return position; // Return the target position
            }
        }

        // Return -1 if any element of the stack match the target
        return -1;
    }


}
