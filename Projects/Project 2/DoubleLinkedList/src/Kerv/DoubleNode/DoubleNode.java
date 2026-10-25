/** ******************************************************************************
 * @Author      :   Kerv Paulina
 * @Date        :   Created On :  October 23, 2026
 * @File        :   Node.java
 * @Description :   Represents a node in a doubly linked list,
 *                  storing an item and references to the previous and next nodes.
 *********************************************************************************/

package DoubleLinkedList.src.Kerv.DoubleNode;


/**
 * Class that stores an item and references to the previous and next nodes. <br>
 * It represents the structure. <br>
 * Its job is to hold an item, a reference to the previous node,
 * and a reference to the next node.
 *
 * @param <T> Generic type class.
 */
public class DoubleNode<T> implements DoubleNodeInterface<T> {

    /**
     * Attribute that store the address of the next item in the List if existed.
     */
    private DoubleNode<T> next;

    /**
     * Attribute that store the address of the current item in the List.
     */
    private T item;

    /**
     * Attribute that store the address of the previous item in the List.
     */
    private DoubleNode<T> previous;

    /**
     * Empty default Constructor...
     */
    public DoubleNode() {
        this(null, null, null);
    }

    /**
     * Overload Constructor with a single parameter (anItem)...
     *
     * @param anItem Item to insert.
     */
    public DoubleNode(T anItem) {
        this(anItem, null, null);  // Call the overload cons by param signature
    }

    /**
     * Overload constructor with multiples parameters (anItem, next, previous)...
     *
     * @param anItem Current item in the List.
     * @param next Next item of the List if existed.
     * @param previous Previous item.
     */
    public DoubleNode(T anItem, DoubleNode<T> next, DoubleNode<T> previous) {
        this.item = anItem;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Mutator method for the item attribute.
     *
     * @param item Modify item attribute value.
     */
    public void setItems(T item) {
        this.item = item;
    }

    /**
     * Mutator method for the Next attribute.
     *
     * @param next Modify Next attribute value.
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Mutator method for the Previous attribute.
     *
     * @param previous Modify previous attribute value.
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Accessor method to the Item attribute.
     *
     * @return Value of Item attribute.
     */
    public T getItems() {
        return item;
    }

    /**
     * Accessor method to the Next attribute.
     *
     * @return Value of Next attribute.
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Accessor method to the Previous attribute.
     *
     * @return Value of Previous attribute.
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    /**
     * Method that returns a string representation of the item stored in the node.
     *
     * @return Returns an item string.
     */
    @Override
    public String toString() {
        if (getItems() == null) {
            return "Node is empty";
        }

        return "DoubleNode [Item: " + item + "]" ;
    }

}
