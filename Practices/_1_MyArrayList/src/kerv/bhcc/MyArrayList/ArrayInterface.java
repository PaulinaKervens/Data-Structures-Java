package kerv.bhcc.MyArrayList;

import kerv.bhcc.ArrayException.ArrayException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ArrayInterface<E> {
    /**
     * Appends the specified element to the end of this stack.
     * If the stack is full, it automatically resizes before adding.
     *
     * @param element the element to be added
     * @throws ArrayException if an error occurs while resizing the stack
     */
    public void add(E element) throws ArrayException;

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
    public void add(int index, E element) throws ArrayException;

    /**
     * Checks if this stack is empty.
     *
     * @return {@code true} if this stack is empty; {@code false} otherwise
     */
    public Boolean isEmpty();

    /**
     * Checks if this stack is full.
     *
     * @return {@code true} if this stack is full; {@code false} otherwise
     */
    public Boolean isFull();

    /**
     * Replaces the element at the specified position in this stack with the specified element.
     *
     * @param index the index of the element to replace
     * @param e the element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E e);

    /**
     * Method to removes an element at an index.
     *
     * @param index the place where the element is located.
     * @return True or False, if the element has been removed.
     */
    public boolean remove(int index);

    /**
     * Method that removes the first matching element.
     * @param o
     * @return True or False, if the element has been removed.
     */
    public boolean removeMatched(Object o);

    /**
     * Method that removes the last element.
     *
     * @return True or False, if the element has been removed.
     */
    public boolean removeLast();

    /**
     * Returns {@code true} if this stack contains the specified element.
     *
     * @param o the element whose presence in this stack is to be tested
     * @return {@code true} if this stack contains the specified element; {@code false} otherwise
     * @throws ArrayException if an error occurs while checking containment
     */
    public boolean contains(final Object o) throws ArrayException;

    /**
     * Returns the index of the first occurrence of the specified element
     * in this stack, or -1 if this stack does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element, or -1 if not found
     */
    public int indexOf(Object o);

    /**
     * Returns the last matching index, or -1.
     * @param o
     * @return
     */
    public int lastIndexOf(Object o);

    /**
     * Returns the element at the specified position in this stack.
     * <p>
     * Time complexity is O(1).
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this stack
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(final int index);

    /**
     * Returns the last element in this stack.
     *
     * @return the last element in this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public E getLast();

    /**
     * Returns the first element in this stack.
     *
     * @return the first element in this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public E getFirst();

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int getSize();

    /**
     * Removes all elements from the stack and resets its capacity to the default capacity.
     *
     * @throws ArrayException if an error occurs while clearing the stack
     */
    public void clear() throws ArrayException;

    /**
     * Returns an iterator over the elements in this stack in proper sequence.
     *
     * @return an iterator over the elements in this stack in proper sequence
     */
    public Iterator<E> iterator();

}
