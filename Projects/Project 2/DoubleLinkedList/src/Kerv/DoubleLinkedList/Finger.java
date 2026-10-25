/** ****************************************
 * @Author      :   Kerv Paulina
 * @Date        :   Created On :  October 23, 2026
 * @File        :   DoubleLinkedList.java
 * @Description :
 *******************************************/


package DoubleLinkedList.src.Kerv.DoubleLinkedList;

import DoubleLinkedList.src.Kerv.DoubleNode.DoubleNode;

public class Finger<T> {
    private DoubleNode<T> node;
    private int idx;

    public Finger(int idx, DoubleNode<T> node) {
        this.idx = idx;
        this.node = node;
    }

    public void setNode(DoubleNode<T> node) {
        this.node = node;
    }

    public void setIndex(int idx) {
        this.idx = idx;
    }

    public int getIndex() {
        return idx;
    }

    public DoubleNode<T> getNode() {
        return node;
    }

}
