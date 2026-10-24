/** ****************************************
 * @Author      :   Kerv Paulina
 * @Date        :   Created On :  October 23, 2026
 * @File        :   DoubleLinkedList.java
 * @Description :
 *******************************************/


package DoubleLinkedList.src.Kerv.DoubleLinkedList;


import DoubleLinkedList.src.Kerv.DoubleNode.DoubleNode;

/**
 * Class that manages the DoubleLinkedList and its operations. <br>
 * It handles operations such as adding, removing, searching, and traversing nodes.
 *
 * @param <T> Type of the DoubleLinkedList (Generics method).
 */
public class DoubleLinkedList<T> implements DoubleLinkedListInterface<T> {

    /**
     * Attribute that store the head of the List.
     */
    private DoubleNode<T> head;

    /**
     * Attribute that store how many item in the List.
     */
    private int itemCount;


    /**
     * Default constructor...
     */
    public DoubleLinkedList() {
        this(null);
    }

    /**
     * Parametrized constructor...
     *
     * @param head Value of head attribute.
     */
    public DoubleLinkedList(DoubleNode<T> head) {
        this.head = head;
        itemCount = 0;
    }

    /**
     * Method that check if the DoubleLinkedList is empty or not.
     *
     * @return A true or False value.
     */
    public boolean isEmpty () {
        return itemCount == 0;
    }

    /**
     * Accessor method that returns the length of the list from itemCount value.
     *
     * @return A positive integer representing the length of the list.
     */
    @Override
    public int getLength() {
        return itemCount;
    }

    /**
     * Method that insert element to the DoubleLinkedList and return a boolean
     * value depends on is the element has been inserted or not.
     *
     * @param position Position where to insert the element, must be a positive number.
     * @param entry    Value to insert at the position.
     * @return A true or False value.
     */
    @Override
    public boolean insert(int position, T entry) {
        return false;
    }

    /**
     * Method that removes the element at position.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     */
    @Override
    public void remove(int position) {

    }

    /**
     * Method that removes all items from the list.
     */
    @Override
    public void clear() {

    }

    /**
     * Gets the item at entry position, provided the position is valid.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     * @return the item found at {@code position}.
     * @throws IndexOutOfBoundsException if the position is unknown.
     */
    @Override
    public T getEntry(int position) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Method that replace in element at entry position, provided the position is valid.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     * @param entry    The element to replace at the {@code position} given.
     * @return Item that was replaced.
     * @throws IndexOutOfBoundsException if the position is unknown.
     */
    @Override
    public T replace(int position, T entry) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Method that return the value of an index given.
     *
     * @param key
     * @return Value of the index if existed.
     * @throws IndexOutOfBoundsException if the position is unknown.
     */
    @Override
    public int getIndexOf(T key) throws IndexOutOfBoundsException {
        return 0;
    }

    /**
     * Method that returns the array form of the list data.
     *
     * @return An array of list data ordered the same as the list.
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     * @return A node from the position given.
     */
    private DoubleNode<T> getNodeAt(final int position) {
        return new DoubleNode<>();
    }


}
