package kerv.bhcc.MyArrayList;

import kerv.bhcc.ArrayException.ArrayException;

public interface ArrayInterface<E> {
    /**
     * Method that allow you to add an element to the end of the  ArrayList.
     * @param element The element to add to the ArrayList
     */
    public void add(E element) throws ArrayException;

    /**
     * Method that add an E element to a specific place.
     * @param index The place where to add that element.
     * @param element The element to add to the ArrayList.
     */
    public void add(int index, E element) throws ArrayException;

    /**
     * Method that check if the ArrayList is Empty.
     * @return True or False.
     */
    public Boolean isEmpty();

    /**
     * Method that check if the ArrayList is full.
     * @return True or False.
     */
    public Boolean isFull();

    /**
     * Method to replaces an element at a specific index.
     * @param index The target.
     * @param e The new element.
     */
    public E set(int index, E e);

    /**
     * Method to removes an element at an index.
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
     * @return True or False, if the element has been removed.
     */
    public boolean removeLast();

    /**
     * Method that Checks whether an element exists in the ArrayList.
     * @param o The element target.
     * @return True or False
     */
    public boolean contains(final Object o) throws ArrayException;

    /**
     * Returns the first matching index, or -1.
     * @param o
     */
    public int indexOf(Object o);

    /**
     * Returns the last matching index, or -1.
     * @param o
     * @return
     */
    public int lastIndexOf(Object o);

    /**
     * Method that get and return an element at a specific location.
     * @param index The element location.
     */
    public E get(final int index);

    /**
     * Method that retrieve and display the last element of the ArrayList.
     * @return An E type of the element list.
     */
    public E getLast();

    /**
     * Method that retrieve and display the last element of the ArrayList.
     *
     * @return An E type of the element list.
     */
    public E getFirst();

    /**
     * Method to get the ArrayList size
     */
    public int getSize();

    public void clear() throws ArrayException;

}
