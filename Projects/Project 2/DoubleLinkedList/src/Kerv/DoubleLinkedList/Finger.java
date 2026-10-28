/** ****************************************
 * @Author      :   Kerv Paulina
 * @Date        :   Created On :  October 23, 2026
 * @File        :   DoubleLinkedList.java
 * @Description :
 *******************************************/


package DoubleLinkedList.src.Kerv.DoubleLinkedList;

import DoubleLinkedList.src.Kerv.DoubleNode.DoubleNode;

/**
 * Class that stores a reference to a node and its position.
 *
 * @param <T> Generic type.
 */
public class Finger<T> {
    /**
     * The node reference.
     */
    private DoubleNode<T> node;

    /**
     * The position of a node in the list.
     */
    private int idx;

    /**
     * Constructor that initializes a finger
     *
     * @param idx The Position of a node in the list {@link #idx}, A positive integer.
     * @param node A {@link #node} address reference.
     */
    public Finger(int idx, DoubleNode<T> node) {
        this.setIndex(idx);
        this.setNode(node);
    }

    /**
     * Node attribute mutator.
     *
     * @param node The node reference.
     */
    public void setNode(DoubleNode<T> node) {
        if (node == null)
            throw new NullPointerException("The node given cannot be null...");
        this.node = node;
    }


    /**
     * Position attribute mutator.
     * @param idx A positive integer.
     */
    public void setIndex(int idx) {
        if (idx < 1)
            throw new IndexOutOfBoundsException("The index must be positive.");
        this.idx = idx;
    }


    /**
     * Position attribute accessor.
     *
     * @return The attribute value.
     */
    public int getIndex() {
        return idx;
    }


    /**
     * Node attribute accessor.
     *
     * @return The node address.
     */
    public DoubleNode<T> getNode() {
        return node;
    }

}
