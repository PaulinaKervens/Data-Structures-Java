package LinkedList.src.kerv.DoublyLinkedList;


/**
 * @Author: (Kerv) Kervens Paulina
 * @Created: November 2, 2026
 *
 * @Project: Circular Doubly Linked List Implementation
 *
 * @Description:
 * This project implements a generic circular doubly linked list from scratch
 * using Java. Each node stores an element and maintains references to both
 * the previous and next nodes, allowing traversal in both directions.
 *
 * The circular structure ensures that the last node points back to the head,
 * while the head's previous reference points to the tail.
 *
 * The implementation provides fundamental linked list operations, including
 * insertion, removal, traversal, and conversion to an array. It also maintains
 * head, tail, and size references to manage the collection efficiently.
 *
 * @param <E> the type of elements stored in the linked list
 *
 * @see java.util.LinkedList
 * @see Node
 * @see #add(Object)
 * @see #add(Object, int)
 * @see #removeAt(int)
 * @see #getNodeAt(int)
 * @see #toArray()
 */

public class MyLinkedList<E> {
    /** The current number of elements contained in the list. */
    private int size;

    /** Reference to the first node (head) of the list. */
    private Node<E> head;

    /** Reference to the last node (tail) of the list. */
    private Node<E> tail;

    /**
     * Constructs an empty circular doubly linked list,
     * initializing size to 0 and head/tail pointers to null.
     */
    public MyLinkedList() {
        this.setSize(0);
        this.setHead(null);
        this.setTail(null);
    }

    /**
     * Constructs a circular doubly linked list initialized with a single starting item.
     *
     * @param item the initial element to add to the list
     */
    public MyLinkedList(E item) {
        this.add(item);
    }

    /**
     * Method that insert a new node to the list.
     * <p>
     * Appends the specified element to the end of this circular doubly linked list. <br>
     * The list maintains a continuous ring structure where the last node links
     * forward to the head, and the head's previous pointer links backward to the tail.<br>
     * O(1) time complexity, Inserts at the tail using the tail reference..
     * </p>
     *
     * @param item the element to be added to the list
     * @return {@code true} if the item was successfully added,
     *         or {@code false} if the provided item is null
     */
    public boolean add(E item) {
        // Check if the item is not null
        if (item == null)
            return false;

        // Create the node
        Node<E> newNode = new Node<>(item);

        // Case 1: The list is currently empty
        if (getSize() == 0) {
            // Initialize head and tail to the new node
            head = newNode;
            tail = newNode;

            // In a single-node circular list, pointers point to itself
            newNode.prev = newNode;
            newNode.next = newNode;
        }
        // Case 2: The list already contains elements
        else {
            // Link the new node after the current tail
            newNode.prev = tail;
            newNode.next = head;

            // Update the surrounding nodes
            tail.next = newNode;
            head.prev = newNode;

            // Update tail
            tail = newNode;
        }

        // increase the size
        size++;

        return true;
    }

    /**
     * Method that insert a new node to the list at a position given.
     * <p>
     * O(n) time complexity, may need to traverse the list to find the insertion position.
     * @param item the element to be added to the list
     * @param position Where to add that element
     * @return {@code true} if the item was successfully added,
     *         or {@code false} if the provided item is null
     */
    public boolean add(E item, int position) {
        // Check if the item is not null and position is valid
        if (item == null || position < 1 || position > size + 1)
            return false;


        // Create the new node
        Node<E> newNode = new Node<>(item);

        // Case 1: If the list is empty
        if (size == 0) {
            // initialize head
            head = newNode;
            tail = newNode;

            // initialize newNode next and prev
            newNode.next = newNode;
            newNode.prev = newNode;
        }

        // Case 2: Insert at the head
        else if (position == 1) {
            // Link the new node after the current tail
            newNode.next = head;
            newNode.prev = tail;

            // Update the surrounding nodes
            head.prev = newNode;
            tail.next = newNode;

            // Update head
            head = newNode;
        }
        // Case 3: Insert at the tail
        else if (position == size + 1) {
            // Link the newNode to the tail and head
            newNode.prev = tail;
            newNode.next = head;

            // Update tail and head
            tail.next = newNode;
            head.prev = newNode;

            // Update tail
            tail = newNode;
        }

        // Case 4: insert at the middle of the list
        else {
            // Condition for if it not at the head
            Node<E> currentNode = getNodeAt(position - 1);
            // Jump to the node that follow it
            Node<E> nextNode = currentNode.getNext();

            // Connect the newNode with the currentNode and the node that follow it
            newNode.prev = currentNode;
            newNode.next = nextNode;

            // Connect current node and next
            currentNode.next = newNode;
            nextNode.prev = newNode;
        }

        // increase size
        size++;

        return true;
    }

    /**
     * Removes the last element from the list.
     * <p>
     * This method removes the tail node from the circular doubly linked list
     * and updates the surrounding references to maintain the circular structure.
     * If the list contains only one element, it resets the list to its initial state.<br>
     * O(1) time complexity, removes the tail directly using the tail reference.
     * </p>
     *
     * @return the element stored in the removed node, or {@code null} if the list is empty
     */
    public E removeLast() {
        // Check if the list is not empty
        if (isEmpty())
            return null;

        Node<E> element = getNodeAt(getSize());

        // Case 1: If the list contain only one element
        if (getSize() == 1) {
            // Just call clear method
            clear();
            // Return the element
            return element.getItem();
        }
        // Case 2: if the list contain multiple element
        else {
            Node<E> prevElement = element.getPrev();

            // Update the element previous and last
            element.prev = null;
            element.next = null;

            // Update the element next pointer that is before the last node we removing
            prevElement.next = head;
            // Update head
            head.prev = prevElement;

        }

        // Decrease size
        size--;

        return element.getItem();
    }

    /**
     * Removes the element at the specified position.
     * <p>
     * This method removes a node from the circular doubly linked list
     * and updates the surrounding references to maintain the circular structure.
     * It handles four cases:
     * <ul>
     *     <li>If the list contains only one element, it resets the list.</li>
     *     <li>If removing the head, it updates the head reference.</li>
     *     <li>If removing the tail, it updates the tail reference.</li>
     *     <li>If removing from the middle, it reconnects the adjacent nodes.</li>
     * </ul>
     * O(n)	time complexity, may need to traverse the list to find the node.
     * </p>
     *
     * @param position the 1-based position of the element to remove
     * @return the element stored in the removed node, or {@code null}
     *         if the list is empty or the position is invalid
     */
    public E removeAt(int position) {
        // Check if the list is empty or invalid position
        if (isEmpty() || (position > getSize() || position < 1))
            return null;

        // Get the node at the position
        Node<E> targetNode = getNodeAt(position);

        // Case 1: If list contain a single element
        if (getSize() == 1) {
            // Just call clear method
            clear();
            // Return the element
            return targetNode.getItem();
        }
        // Case 2: if the target is the head
        else if (position == 1){
            // get the next node after the target node
            Node<E> targetNext = targetNode.getNext();

            // Update the next node after the target node previous pointer
            targetNext.prev = tail;
            // Update tail next pointer to point to the target next
            tail.next = targetNext;

            // Update head to be the node that after the target
            head = targetNext;
        }
        // Case 3: if the target is in the middle or is the tail
        else {
            // Get the node before it
            Node<E> targetPrev = targetNode.getPrev();

            // get the node after it
            Node<E> targetNext = targetNode.getNext();

            // Update the surrounding node pointers
            targetPrev.next = targetNext;
            targetNext.prev = targetPrev;

            // Inner case: Update tail only if removing the last node
            if (position == size) {
                // Update tail to be the node before that the target
                tail = targetPrev;
            }
        }

        // Detach the removed node
        targetNode.next = null;
        targetNode.prev = null;

        // Decrease the size
        size--;

        // Return the element removed
        return targetNode.getItem();
    }

    /**
     * Retrieves, but does not remove, the last element (tail) of this list.
     * <p>
     * This method accesses the element stored in the tail node without
     * modifying the list structure or its size. <br>
     * O(1) time complexity.
     * </p>
     *
     * @return the last element in the list, or {@code null} if the list is empty
     *
     * @see #removeLast()
     * @see #getTail()
     */
    public E peek() {
        // Check if the list contains any elements
        if (isEmpty())
            return null;

        // Return the data item stored in the tail node without removing it
        return tail.getItem();
    }



    /**
     * Removes all items from the list.
     *
     * <p>This method resets the list to its initial state by:
     * <ul>
     *   <li>Initializing {@link #head} to {@code null}.</li>
     *   <li>Setting {@link #size} to 0.</li>
     * </ul>
     * O(1)	time complexity, resets head, tail, and size without traversing nodes.
     * </p>
     */
    public void clear() {
        setSize(0);
        setHead(null);
        setTail(null);
    }

    /**
     * Method that retrieve the node at a position given.
     * <p>
     * O(n) time complexity, may traverse up to the requested position.
     * </p>
     *
     * @param position Position where to remove the element, must be a positive number and list length inclusive;
     * @return A node from the position given.
     */
    public Node<E> getNodeAt(int position) {
        // Check if the item is not null and position is valid
        if (position > getSize() || position < 1)
            return null;

        // Create the walker node
        Node<E> walker = head;

        for (int i = 1; i < position; i++) {
            walker = walker.getNext();
        }

        // Return the element
        return walker;
    }

    /**
     * Method that returns the array form of the list data.
     * <p>
     *     O(n)	time complexity, visits every node once.
     * </p>
     *
     * @return An array of list data ordered the same as the list.
     */
    public Object[] toArray() {
        // Check if the list is not empty
        if (isEmpty())
            return null;

        // Create a dynamic array of object from Object class
        Object[] array = new Object[getSize()];

        // Get the head of the list to
        Node<E> walker = head;

        // Walk through the list
        for (int index = 0; index < getSize(); index++) {
            array[index] = walker.getItem();
            walker = walker.getNext();
        }

        return array;
    }

    /**
     * Checks if the list is currently empty.
     * <p>O(1) time complexity, checks whether size == 0.</p>
     * @return {@code true} if the list contains no elements, {@code false} otherwise
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Sets the head node of the list.
     *
     * @param head the node to be assigned as the new head
     */
    private void setHead(Node<E> head) { this.head = head; }

    /**
     * Sets the tail node of the list.
     *
     * @param tail the node to be assigned as the new tail
     */
    private void setTail(Node<E> tail) { this.tail = tail; }

    /**
     * Updates the total item count (size) of the list.
     *
     * @param itemsCount the new size value to set
     */
    private void setSize(int itemsCount) { this.size = itemsCount; }

    /**
     * Returns the current number of elements in the list.
     * <p>O(1) time complexity, returns the stored size.</p>
     * @return the size of the list
     */
    public int getSize() { return size; }

    /**
     * Retrieves the head node of the list.
     *
     * @return the head node reference
     */
    private Node<E> getHead() { return head; }

    /**
     * Retrieves the tail node of the list.
     *
     * @return the tail node reference
     */
    private Node<E> getTail() { return tail; }

    /**
     * Method that returns a String that represents the
     * content of the list.
     * <p>
     *     O(n) time complexity, visits every element once, assuming each element's string conversion is O(1).
     * </p>
     * @return String list content.
     */
    @Override
    public String toString() {
        // Check the list
        if (isEmpty())
            return ("Empty List.");

        StringBuilder result = new StringBuilder();
        int countEntry = 0;

        // Read the loop to extract each element name and value
        // Start with index = 1 to handle the exception for a position < 1;
        for (int index = 1; index <= getSize(); index++) {
            // Concatenate the value found to the string
            result.append("[" + ++countEntry + "] " + getNodeAt(index)).append("\n");
        }

        // Return the result
        return result.toString();
    }



    /**
     * Nested node class representing an individual element in the circular doubly linked list.
     *
     * @param <E> the type of element held in this node
     */
    private static class Node<E> {
        /** The data element stored within this node */
        E item;

        /** Reference to the next node in the list */
        Node<E> next;

        /** Reference to the previous node in the list */
        Node<E> prev;

        /**
         * Constructs a new node with the specified element and null pointers.
         *
         * @param element the element to be stored in this node
         */
        Node(E element) {
            this.setItem(element);
            this.setNext(null);
            this.setPrev(null);
        }

        /**
         * Constructs a new node with a specified previous node, element, and next node.
         *
         * @param prev    reference to the previous node
         * @param element the element to be stored in this node
         * @param next    reference to the next node
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.setItem(element);
            this.setNext(next);
            this.setPrev(prev);
        }

        /**
         * Sets the reference to the previous node.
         *
         * @newNode the node to set as previous
         */
        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        /**
         * Sets the data element stored in this node.
         *
         * @item the element to set
         */
        private void setItem(E item) {
            this.item = item;
        }

        /**
         * Sets the reference to the next node.
         *
         * @next the node to set as next
         */
        private void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Returns the data element stored in this node.
         *
         * @return the stored element
         */
        private E getItem() {
            return item;
        }

        /**
         * Returns the reference to the next node.
         *
         * @return the next node reference
         */
        private Node<E> getNext() {
            return next;
        }

        /**
         * Returns the reference to the previous node.
         *
         * @return the previous node reference
         */
        private Node<E> getPrev() {
            return prev;
        }
    }

}
