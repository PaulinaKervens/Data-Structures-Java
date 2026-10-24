package DoubleLinkedList.src.Kerv.DoubleNode;

public interface DoubleNodeInterface<T> {

    /**
     * Mutator method for the item attribute.
     *
     * @param item Modify item attribute value.
     */
    public void setItems(T item);

    /**
     * Mutator method for the Next attribute.
     *
     * @param next Modify Next attribute value.
     */
    public void setNext(DoubleNode<T> next);

    /**
     * Mutator method for the Previous attribute.
     *
     * @param previous Modify previous attribute value.
     */
    public void setPrevious(DoubleNode<T> previous);

    /**
     * Accessor method to the Item attribute.
     *
     * @return Value of Item attribute.
     */
    public T getItems();

    /**
     * Accessor method to the Next attribute.
     *
     * @return Value of Next attribute.
     */
    public DoubleNode<T> getNext();

    /**
     * Accessor method to the Previous attribute.
     *
     * @return Value of Previous attribute.
     */
    public DoubleNode<T> getPrevious();

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
