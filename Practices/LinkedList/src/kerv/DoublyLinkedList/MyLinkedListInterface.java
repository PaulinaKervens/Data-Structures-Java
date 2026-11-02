package LinkedList.src.kerv.DoublyLinkedList;

public interface MyLinkedListInterface<E> {
    /**
     * Method that insert a new node to the list.
     * <p>
     * Appends the specified element to the end of this circular doubly linked list. <br>
     * The list maintains a continuous ring structure where the last node links
     * forward to the head, and the head's previous pointer links backward to the tail.
     * </p>
     *
     * @param item the element to be added to the list
     * @return {@code true} if the item was successfully added,
     *         or {@code false} if the provided item is null
     */
    public boolean add(E item);

    /**
     * Method that insert a new node to the list at a position given.
     * <p>
     * @param item the element to be added to the list
     * @param position Where to add that element
     * @return {@code true} if the item was successfully added,
     *         or {@code false} if the provided item is null
     */
    public boolean add(E item, int position);

    /**
     * Removes the last element from the list.
     * <p>
     * This method removes the tail node from the circular doubly linked list
     * and updates the surrounding references to maintain the circular structure.
     * If the list contains only one element, it resets the list to its initial state.
     * </p>
     *
     * @return the element stored in the removed node, or {@code null} if the list is empty
     */
    public E removeLast();



}
