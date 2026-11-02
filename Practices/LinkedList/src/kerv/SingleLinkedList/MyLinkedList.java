package LinkedList.src.kerv.SingleLinkedList;


public class MyLinkedList<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        this.setSize(0);
        this.setHead(null);
        this.setTail(null);
    }

    public MyLinkedList(E item) {
        this.add(item);
    }

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
        }

        // increase the size
        size++;

        return true;
    }

    /**
     * Method that insert a new node to the list at a position given.
     * <p>
     * @param item the element to be added to the list
     * @param position Where to add that element
     * @return {@code true} if the item was successfully added,
     *         or {@code false} if the provided item is null
     */
    private boolean add(E item, int position) {
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
     *
     * @param position
     * @return
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

    public Object[] toArray() {
        // Check if the list is not empty
        if (isEmpty())
            return null;

        // Create a dynamic array of object from Object class
        Object[] array = new Object[getSize()];

        // Get the head of the list to
        Node<E> walker = head;

        for (int index = 0; index < getSize(); index++) {
            array[index] = walker.getItem();
            walker = walker.getNext();
        }

        return array;
    }

    /**
     * Checks if the list is currently empty.
     *
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
     *
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
