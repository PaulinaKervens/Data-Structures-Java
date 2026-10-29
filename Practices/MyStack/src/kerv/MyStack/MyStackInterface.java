package MyStack.src.kerv.MyStack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface MyStackInterface<T> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto the stack
     * @return the item argument
     * @throws StackOverflowError if the stack is full
     */
    public T push(T item);

    /**
     * Removes and returns the top element from this stack.
     *
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop();

    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return the object at the top of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public T peek();

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns an array containing all the elements in this stack in proper sequence.
     *
     * @return an array containing the elements of the stack
     */
    public T[] toArray();

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator over the elements in the stack
     */
    public Iterator<T> iterator();

    /**
     * Check if an element is in the stack;
     *
     * @param o
     * @return -1 if not found; or the element position.
     */
    public int search(Object o);
}
