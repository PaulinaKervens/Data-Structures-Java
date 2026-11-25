package _5_BinarySearchTree.BinarySearchTree.src.kerv;

public class BinarySearchTree<T extends Comparable<T>>{

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node<T> current = root;
        Node<T> parent = root;

        while(current != null) {
            parent = current;

            // Compare the current value with the data to insert
            int result = current.getData().compareTo(data);

            // Case : 1. if the result is greater than the data to insert
            if (result > 0) {
                current = current.getLeft();
            }
            // Case : 2. if the result is smaller than the data to insert
            else if (result < 0){
                current = current.getRight();
            }
            // Case : 3. if the result and the data are equal, pass
            else {
                return;
            }

        }

        int parentComResult = parent.getData().compareTo(data);

        if (parentComResult > 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

    }

    private void inOrder(Node<T> root) {
        if (root == null ) return;

        inOrder(root.getLeft());
        IO.println(root.getData());
        inOrder(root.getRight());
    }

    public void inOrder() {
        inOrder(root);
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
