/*****************************************************************
 * @Author :        Kerv Paulina
 * @Date :          Created On :  October 23, 2026
 * @File :          DoubleLinkedList.java
 * @Description :   Class that implements the operations of a
 *                  doubly linked list, such as insertion, removal,
 *                  searching, sorting, and accessing entries.
 ***************************************************************/


package DoubleLinkedList.src.Kerv.DoubleLinkedList;

import DoubleLinkedList.src.Kerv.DoubleNode.DoubleNode;

import java.util.Comparator;


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
    public boolean isEmpty() {
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
        if ((position < 1) || position > (itemCount + 1)) {
            System.err.println("Position is out of range..");
            return false;
        } else if (entry == null) {
            return false;
        }

        // Create the node by passing the entry value as param
        DoubleNode<T> newDoubleNode = new DoubleNode<>(entry);

        // Check the position if that is the first position
        // To insert at the beginning of the list
        if (position == 1) {
            // initialize the head of the list
            newDoubleNode.setNext(head);

            // Check if there is any previous node
            if (head != null) {
                head.setPrevious(newDoubleNode);
            }

            // Initialize head to hold the first value in the list
            head = newDoubleNode;

            // Increase itemCount as we insert element
            itemCount++;

            // Update the finger
            updateFinger();

            return true;
        }

        // If it not the first element to insert
        // Get the node immediately before the insertion position
        // Create and initialise {@code previous} attribute to always point at the previous inserted node
        // by getting the node at position - 1.
        DoubleNode<T> previous = getNodeAt(position - 1);

        // Get the node that currently follows previous
        DoubleNode<T> next = previous.getNext();

        // Link the new node to its neighbors nodes
        // Set the new node's previous reference to the preceding node
        newDoubleNode.setPrevious(previous);
        // initialize the next pointer of newDoubleNode with the value of next pointer of previous
        newDoubleNode.setNext(next);
        // Update the preceding node's next reference to the new node
        previous.setNext(newDoubleNode);

        // If a following node exists, update its previous reference
        if (next != null) {
            next.setPrevious(newDoubleNode);
        }

        // Update the number of items as we insert element
        itemCount++;

        // Update the finger
        updateFinger();

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
        if (isEmpty()) {
            IO.println("List is empty");
            return null;
        }
        // Check for in invalid position
        else if (position > getLength() || position < 1) {
            System.out.println("The position given is out of the list range.");
            return null;
        }

        // Create a temporary node for the removed element
        // Initialize it with the head of the list
        DoubleNode<T> tempNode = head;

        // Condition if the list that has only one node
        if (itemCount == 1) {
            // As there is one node in the list, just clear the list
            clear();
            // Return the item removed
            return tempNode.getItems();
        }

        // Condition for a list with multiple element
        // For removing the first node,
        if (position == 1) {
            // Get the next node
            head = head.getNext();
            // Remove the previous node address
            head.setPrevious(null);
        } else {
            // Get a previous DoubleNode
            DoubleNode<T> previous = getNodeAt(position - 1);
            // Get the node to remove from the list
            tempNode = previous.getNext();
            // initialize the next of previous with the first node
            previous.setNext(tempNode.getNext());

            // Check if the next node is not null
            if (tempNode.getNext() != null) {
                tempNode.getNext().setPrevious(previous);
            }
        }

        // decrement the list item
        itemCount--;

        // Update the finger
        updateFinger();

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
        fingers = new Finger[2];
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
        if (isEmpty()) {
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
        if (isEmpty() || (position > getLength() || position < 1)) {
            throw new IndexOutOfBoundsException("Position is invalid");
        }

        // Check and Handle the null pointer exception
        if (entry == null) {
            throw new NullPointerException("The element cannot be null.");
        }

        // Create a tempo node
        DoubleNode<T> node = getNodeAt(position);
        // Get the node value to change
        T element = node.getItems();
        // Update the node value
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
        if (isEmpty() || key == null) {
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
        if (isEmpty() || (position < 1) || position > itemCount) {
            return null; // return null
        }

        // Start traversal from the closest finger's node
        Finger<T> finger = getClosest(position);
        DoubleNode<T> walker = finger.getNode();
        // Get the number of step to get to the target
        int steps = Math.abs(position - finger.getIndex());

        // Walk through the node until reaching the position given
        for (int index = 0; index < steps; index++) {
            if (finger.getIndex() < position) {
                walker = walker.getNext();
            } else {
                walker = walker.getPrevious();
            }
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
        // Check the list
        if (isEmpty()) {
            return ("Empty List.");
        }

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
     * Updates the finger array by distributing the fingers evenly
     * across the doubly linked list. Each finger stores a position
     * and a reference to the node at that position.
     *
     * If the list is empty, the finger array is reset.
     */
    private void updateFinger() {
        // Check if the list is empty
        // and reset the finger array
        if (isEmpty()) {
            // Create a new finger array with 2 capacity
            fingers = new Finger[2];
            return;
        }

        // Get the total number of fingers
        // We will know how many fingers need to be updated
        int numberOfFingers = fingers.length;

        // Walk through the finger array
        for (int index = 0; index < numberOfFingers; index++) {
            final var position = getPosition(numberOfFingers, index);

            // Temp DoubleNode object
            DoubleNode<T> node = head;

            // Find the target node by moving forward until
            // we reach the calculated position
            for (int j = 1; j < position; j++) {
                node = node.getNext();
            }

            // Create and replace the finger
            fingers[index] = new Finger<>(position, node);
        }
    }

    /**
     * Helper method that distribute finger evenly across the list.<br>
     * Formular used : position = 1 + round ( i(n-1)/ f - 1 ) <br>
     * Where :
     *         i = current finger index, starting at 0
     *         n = list length
     *         f = number of fingers
     *
     * @param numberOfFingers Number of finger to update
     * @param index The target finger index
     * @return The node position
     */
    private int getPosition(int numberOfFingers, double index) {
        int position;

        // Calculate the position where the current finger should point
        // Handle the case where there is only one finger
        if (numberOfFingers == 1) {
            position = 1;
        }
        // Handle the case where there is many fingers
        else {
            // Calculate the position where the current finger should point
            // based on the list length and the total number of fingers
            position = 1 + (int) Math.round(index * (getLength() - 1) / (numberOfFingers - 1));
        }
        return position;
    }


    /**
     * Method that finds and returns the closest finger to the requested index.<br>
     * It compares the distance between each finger and the
     * target index to determine the closest starting point.
     *
     * @param idx The target index in the list.
     * @return The closest Finger object to the requested index.
     * @throws IndexOutOfBoundsException If the list is empty or the index is invalid.
     */
    private Finger<T> getClosest(int idx) {
        // Check if the list is empty or the index is out of range
        if (idx < 1 || idx > getLength() || isEmpty()) {
            throw new IndexOutOfBoundsException("The requested index is invalid.");
        }

        // Initialize the closest finger with the head of the list
        Finger<T> closest = new Finger<>(1, head);
        // Get the smallest distance from the index
        int smallestDistance = Math.abs(idx - 1);

        // Walk through the array finger
        for (Finger<T> finger : fingers) {
            // Condition to check if the value retrieve is null
            // to skip it
            if (finger != null) {
                // Get the distance between the finger and the index target
                int distance = Math.abs(idx - finger.getIndex());
                // Update the closest finger if a shorter distance is found
                if (distance < smallestDistance) {
                    smallestDistance = distance;
                    closest = finger;
                }
            }
        }

        // Return the closest finger found (position and DoubleNode reference)
        return closest;
    }


    /**
     * Method sorts list using the bubble sort algorithm. <br>
     * <p>This method compares two items and swaps them whenever the
     *  current item is greater than the next item, according to the comparator.</p>
     *  It repeats the process until no swaps occur.
     *
     * @param comparator the comparator used to compare the items in the list.
     */
    public void sort(Comparator<T> comparator) {
        // Check if the list is not empty or if only one element exist
        if (isEmpty() || (getLength() == 1)) {
            return;
        }

        // Local variable to get track if a swap has been made
        boolean swapped;

        // Repeat passes until no swaps occur
        do {
            // initialize swapped
            swapped = false;

            // Get the first node
            DoubleNode<T> walker = head;

            // Inner loop to stay inside to be able to swap other item if needed
            while (walker.getNext() != null) {
                // Compare both nodes
                int result = comparator.compare(walker.getItems(), walker.getNext().getItems());

                // Temporary variable to save the current item before swap
                if (result > 0) {
                    T tempItem = walker.getItems();

                    // Set the current item with the next item value
                    walker.setItems(walker.getNext().getItems());

                    // Set the next item with the previous item value
                    walker.getNext().setItems(tempItem);

                    // Record that a swap happened
                    swapped = true;
                }
                // Move walker to the next node
                walker = walker.getNext();
            }
        // Continue in the loop or not depend on swapped value
        } while (swapped);
    }


}
