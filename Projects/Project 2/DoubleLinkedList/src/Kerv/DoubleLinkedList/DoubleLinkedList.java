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
     *
     */
    private Finger<T>[] fingers;


    /**
     * Default constructor...
     */
    public DoubleLinkedList() {
        this.head = null;
        this.itemCount = 0;
        this.fingers = new Finger[2];   // Allocate a fingers array with a default capacity of 2
    }

    /**
     * Method that determines whether the list contains any items.
     *
     * @return true if the list contains no items; false otherwise.
     */
    public boolean isEmpty () {
        return getLength() == 0;
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
     * @param position Position where to insert the element, must be a positive number,
     *                 and less than itemCount + 1.
     * @param entry    Value to insert at the position.
     * @return true if the entry has been added; false otherwise.
     */
    @Override
    public boolean insert(int position, T entry) {
        // Check if the position given is a positive number
        // And if not exceed the List
        if ( (position < 1) || position > (itemCount + 1) ) {
            IO.println("The position must be a positive number, please enter a positive number...");
            return false;
        }

        // Create the node object by passing the entry value as param
        DoubleNode<T> newDoubleNode = new DoubleNode<>(entry);

        // Check the position if that is the first position
        // To set the head of the list
        if (position == 1) {
            newDoubleNode.setNext(head);
            head = newDoubleNode;   // Initialize head to hold the first value in the list
            // Increase itemCount as we insert element
            itemCount++;
            return true;
        }

        // If it not the first element to insert
        // Create and initialise {@code previous} attribute to always point at the previous inserted node
        // by getting the node at position - 1.
        DoubleNode<T> previous = getNodeAt(position - 1);

        // Save the node that currently follows previous
        DoubleNode<T> next = previous.getNext();

        // initialize the next pointer of newDoubleNode with the value of next pointer of previous
        newDoubleNode.setNext(next);

        // Set the new node's previous reference to the preceding node
        newDoubleNode.setPrevious(previous);

        // If a following node exists, update its previous reference
        if (next != null) {
            next.setPrevious(newDoubleNode);
        }

        // Update the preceding node's next reference to the new node
        previous.setNext(newDoubleNode);

        // Increase itemCount as we insert element
        itemCount++;

        // Return true after insertion
        return true;
    }


    /**
     * Method that removes the element at position.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     */
    @Override
    public T remove(int position) {
        // Check if the list is empty
        if (isEmpty()){
            IO.println("List is empty");
            return null;
        }

        // Create a tampon value for the element removed
        // initialize the tempo with the only value in the list (head)
        DoubleNode<T> tempNode = head;

        // Condition if the list that has only one node
        if (itemCount == 1) {
            clear();    // just clear the list
            return tempNode.getItems();    // Return the item removed
        }

        // Create a previous DoubleNode
        DoubleNode<T> previous = getNodeAt(position - 1);
        // initialize our temp DoubleNode with the next node.
        tempNode = previous.getNext();
        // initialize the next of previous with the first node
        previous.setNext(tempNode.getNext());
        // decrement the list item
        itemCount--;

        // Return the item removed
        return tempNode.getItems();
    }


    /**
     * Removes all items from the list.
     *
     * <p>This method resets the list to its initial state by:
     * <ul>
     *   <li>Initializing {@link #head} to {@code null}.</li>
     *   <li>Setting {@link #itemCount} to 0.</li>
     * </ul>
     * </p>
     */
    @Override
    public void clear() {
        this.head = null;
        this.itemCount = 0;
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
        // Check if the node is not empty
        if (isEmpty()){
            throw new IndexOutOfBoundsException("List is empty");
        }
        // Check if position is not greater than the number of item in the list
        else if (position > itemCount) {
            throw new IndexOutOfBoundsException("Position given must be accurate to the list...");
        }
        // Check if the node is not a negative or zero number
        else if (position < 1) {
            throw new IndexOutOfBoundsException("Position must be a positive number...");
        }

        // return the entry
        return getNodeAt(position).getItems();
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
        // Check if the list is empty
        if (isEmpty() || position > getLength()) {
            throw new IndexOutOfBoundsException("");
        }

        DoubleNode<T> node = getNodeAt(position);
        T element = node.getItems();
        node.setItems(entry);

        return element;
    }


    /**
     * Method that return the value of an index given.
     *
     * @param key The entry target.
     * @return Value of the index if existed.
     * @throws IndexOutOfBoundsException if the position is unknown.
     */
    @Override
    public int getIndexOf(T key) {
        // check if list is empty
        if (isEmpty()) {
            return -1;
        }

        // Create a local variable to get track of the position
        int position = 0;

        // create a DoubleNode object initialized with the head to start walking in the list
        DoubleNode<T> walker = head;

        // Read the list
        for (int index = 0; index < getLength(); index++) {
            // Increment
            position++;

            // Check if the current node is the same as the key
            if (walker.getItems().equals(key)) {
                return position;    // If yes return the position immediately
            }

            // Move walker to the next node
            walker = walker.getNext();
        }

        // Not found
        return -1;
    }


    /**
     * Method that returns the array form of the list data.
     *
     * @return An array of list data ordered the same as the list.
     */
    @Override
    public Object[] toArray() {
        // Check if the list is not empty
        if (isEmpty()) {
            return null;
        }

        // Create a dynamic array of object from Object class
        Object[] array = new Object[getLength()];

        // Create and initialize an object of DoubleNode to start from the beginning of the list
        DoubleNode<T> walker = head;

        // Read the node
        for (int index = 0; index < getLength(); index++) {
            // Insert each node to the array
            array[index] = walker.getItems();
            // Move to the next node by initialize walker with getNext()
            walker = walker.getNext();
        }

        // return the array
        return array;
    }


    /**
     * Method that retrieve the node at a position given.
     *
     * @param position Position where to remove the element, must be a positive number
     *                 and list length inclusive;
     * @return A node from the position given.
     */
    private DoubleNode<T> getNodeAt(final int position) {
        // Check if the list is empty or
        // the position is not negative or
        // position is not greater than the item present in the list(itemCount)
        if (isEmpty() || (position < 1) || position > itemCount ) {
            return null; // return null
        }

        // if the list is not initialize with the head of the list
        DoubleNode<T> walker = head;

        // Walk through the node until reaching the position given
        for (int index = 0; index < position - 1; index++) {
            walker = walker.getNext();  // Keep moving to the next one
        }

        // Return the element at the position given
        return walker;
    }


    /**
     * Method that returns a String that represents the
     * content of the list.
     *
     * @return String list content.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int countEntry = 0;

        // Read the loop to extract each element name and value
        // Start with index = 1 to handle the exception for a position < 1;
        for (int index = 1; index <= itemCount; index++) {
            // Concatenate the value found to the string
            result.append("[" + ++countEntry + "] " + getEntry(index)).append("\n");
        }

        // Return the result
        return result.toString();
    }


    /**
     *
     * @param key
     * @param position
     */
    private void updateFinger(DoubleNode<T> key, int position) {

    }


    /**
     *
     *
     * @param idx The position of a node in the list.
     * @return
     */
    private Finger<T> getClosest(int idx) {
        return null;
    }


}
