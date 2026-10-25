package DoubleLinkedList.src.Kerv.DoubleLinkedList;

public interface DoubleLinkedListInterface<T> {

    /**
     * Method that check if the DoubleLinkedList is empty or not.
     *
     * @return A true or False value.
     */
    public boolean isEmpty();

    /**
     * Accessor method that returns the length of the list from itemCount value.
     *
     * @return A positive integer representing the length of the list.
     */
    public int getLength();

    /**
     * Method that insert element to the DoubleLinkedList and return a boolean
     * value depends on is the element has been inserted or not.
     *
     * @param position Position where to insert the element, must be a positive number.
     * @param entry Value to insert at the position.
     * @return A true or False value.
     */
    public boolean insert(int position, T entry);

    /**
     * Method that removes the element at position.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     */
    public T remove(final int position);

    /**
     * Method that removes all items from the list.
     */
    public void clear();

    /**
     * Gets the item at entry position, provided the position is valid.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     * @throws IndexOutOfBoundsException if the position is unknown.
     * @return the item found at {@code position}.
     */
    public T getEntry(final int position) throws IndexOutOfBoundsException;

    /**
     * Method that replace in element at entry position, provided the position is valid.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     * @param entry The element to replace at the {@code position} given.
     * @return Item that was replaced.
     * @throws IndexOutOfBoundsException if the position is unknown.
     */
    public T replace(int position, final T entry) throws IndexOutOfBoundsException;

    /**
     * Method that return the value of an index given.
     *
     * @param key
     * @return Value of the index if existed.
     * @throws IndexOutOfBoundsException if the position is unknown.
     */
    public int getIndexOf(T key) throws IndexOutOfBoundsException;

    /**
     * Method that returns the array form of the list data.
     *
     * @return An array of list data ordered the same as the list.
     */
    public Object[] toArray();

}
