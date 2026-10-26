/** ****************************************
 * @Author      :   Kerv Paulina
 * @Date        :   Created On :  October 23, 2026
 * @File        :   DoubleLinkedList.java
 * @Description :
 *******************************************/


package DoubleLinkedList.src.Kerv.DoubleLinkedList;

import DoubleLinkedList.src.Kerv.DoubleNode.DoubleNode;

/**
 * Class that searching through the Double linked list.
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
     * Default constructor.
     *
     * @param idx Position of a node in the list, A positive integer..
     * @param node Node reference.
     */
    public Finger(int idx, DoubleNode<T> node) {
        this.idx = idx;
        this.node = node;
    }

    /**
     * Node attribute mutator.
     *
     * @param node The node reference.
     */
    public void setNode(DoubleNode<T> node) {
        this.node = node;
    }


    /**
     * Position attribute mutator.
     * @param idx A positive integer.
     */
    public void setIndex(int idx) {
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
