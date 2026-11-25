package _5_BinarySearchTree.BinarySearchTree.src;

import _5_BinarySearchTree.BinarySearchTree.src.kerv.BinarySearchTree;

public class Main {
     static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.add(100);
        bst.add(50);
        bst.add(150);
        bst.add(20);
        bst.add(120);
        bst.add(60);
        bst.add(160);
        bst.add(30);
        bst.add(180);

        bst.inOrder();

    }

}
