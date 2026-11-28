
package _5_BinarySearchTree.BinarySearchTree.src.kerv;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>>
implements Iterable<T> {

    /** The first node of the tree. It is null when the tree is empty */
    private Node<T> root;

    /**
     * No-arg constructor.
     * Creates an empty Binary Search Tree.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Add method. <br>
     * Method that adds a new element to the tree while keeping the BST rules.
     * Duplicate values are not allowed.
     *
     * @param data the value to add to the tree
     */
    public void add(T data) {
        // Create a new node
        Node<T> newNode = new Node<>(data);

        // If the tree is empty, the new node becomes the root.
        if (isEmpty()) {
            root = newNode;
            return;
        }

        // Start at the root and keep track of the previous node.
        Node<T> current = root;
        Node<T> parent = root;

        // Move through the tree until we find an empty position.
        while (current != null) {
            parent = current;

            // Compare the current value with the value we want to add.
            int result = current.getData().compareTo(data);

            // If the current value is greater, move to the left subtree.
            if (result > 0) {
                current = current.getLeft();
            }
            // If the current value is smaller, move to the right subtree.
            else if (result < 0) {
                current = current.getRight();
            }
            // If both values are equal, the element is already in the tree.
            else {
                return;
            }
        }

        // Connect the new node to its parent in the correct position.
        int parentComResult = parent.getData().compareTo(data);

        if (parentComResult > 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }


    /**
     * Prints the elements of the tree in ascending order.
     *
     * @param current the node where the traversal starts
     */
    private void inOrder(Node<T> current) {
        // Stop when there is no node to visit.
        if (current == null) return;

        // Visit the left subtree, print the current value,
        // then visit the right subtree.
        inOrder(current.getLeft());
        IO.println(current);
        inOrder(current.getRight());
    }

    /**
     * Starts the in-order traversal from the root.
     */
    public void inOrder() {
        inOrder(root);
    }


    /**
     * Prints the elements of the tree in ascending order.
     *
     * @param current the node where the traversal starts.
     */
    private void preOrder(Node<T> current) {
        // Stop when there is no node to visit.
        if (current == null) return;

        // Print the current value, visit the left subtree,
        // then visit the right subtree.
        IO.println(current);
        preOrder(current.getLeft());
        preOrder(current.getRight());
    }

    /**
     * Starts the pre-order traversal from the root.
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * Prints the elements of the tree in desc order, by right child first,
     * left child and parent.
     *
     * @param current the node where the traversal starts.
     */
    private void postOrder(Node<T> current) {
        // Stop when there is no node to visit.
        if (current == null) return;

        // Visit the left subtree, then visit the right subtree
        // then print the current value.
        postOrder(current.getLeft());
        postOrder(current.getRight());
        IO.println(current);
    }

    /**
     * Starts the post-order traversal from the root.
     */
    public void postOrder() {
        postOrder(root);
    }



    /**
     * Checks whether the tree is empty.
     *
     * @return true if the tree has no elements, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }


    /**
     * Represents a single node in the Binary Search Tree.
     *
     * @param <T> the type of data stored in the node
     */
    static class Node<T> {

        /** References to the left child of the node */
        private BinarySearchTree.Node<T> left;

        /** References to the right child of the node */
        private BinarySearchTree.Node<T> right;

        /** The value stored in this node */
        private T data;


        /**
         * No-arg constructor. <br>
         * It creates a node with the given value and no children that become a leaf.
         *
         * @param data The data to create the node
         */
        Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getRight() {
            return right;
        }

        public Node<T> getLeft() {
            return left;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node [data = " + getData() + "]";
        }
    }
}
