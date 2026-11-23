package _5_BinarySearchTree.BinarySearchTree.src.kerv;

public class BinarySearchTree<T> {

    private Node root;


    public BinarySearchTree() {

    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            root = newNode;
        } else {

        }


    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }


    /**
     *
     */
    static class Node<T> {

        private BinarySearchTree.Node<T> left;
        private BinarySearchTree.Node<T>  right;
        private T data;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

}
