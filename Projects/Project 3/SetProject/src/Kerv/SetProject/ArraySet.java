package Kerv.SetProject;

import java.util.Iterator;

/**
 *
 * @param <E>
 * @author Kerv Paulina
 * @since Mon, Nov 23 2026
 */
public class ArraySet<E extends Comparable<E>> extends AbstractSet<E> {

    /** Array attribute that storing the elements in the set */
    private E[] elements;

    /** Array capacity */
    private int capacity;


    /**
     * Constructs a {@code ArraySet} that initialize the attribute with default value.
     */
    @SuppressWarnings("unchecked")
    public ArraySet() {
        this.capacity = 10;     // Initialize the capacity by default to 10
        elements = (E[]) new Comparable[capacity];      // Allocate the array memory
        count = 0;          // Initialize count to indicate the set is empty
    }

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param element the element to be added to this set
     * @return {@code true} if the set did not already contain the specified element,
     * {@code false} otherwise
     */
    @Override
    public boolean add(E element) {
        // Check for null and if the Set already have the element for duplicate element
        if (element == null || contains(element))
            return false;

        // Expand array if necessary.
        if (count == capacity)
            expandCapacity();


        /*// 4. Find correct sorted position.
        for (int index = 0; index < count -1; index++) {
            if (elements[index].compareTo(element)) {

            }
        }
*/

        // 5. Shift elements to make room.

        // Insert element
        elements[count] = element;

        // Update count
        count++;

        return true;
    }

    /*private void sort() {
        for (int index = 0; index < count -1; index++) {
            if (elements[index].compareTo(index++) == 1) {

            }
        }
    }*/


    //

    /**
     * Helper method that swap two elements place.
     *
     * @param index1 First element index.
     * @param index2 Second element index
     * @return true if the swap was successful; otherwise false.
     */
    private boolean swap(int index1, int index2) {
        // Check if both index arg are in a valid array indices
        if (index1 < 0 || index2 < 0)
            return false;

        // Temporarily store the element at index1 so it isn't overwritten
        E element = elements[index1];

        // Move the element from index2 into index1
        elements[index1] = elements[index2];

        // Place the saved element into index2
        elements[index2] = element;

        // Indicate that the swap completed
        return true;
    }

    /**
     * Doubles the backing array capacity and copies existing elements into a larger array.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        // Double the current capacity
        final int newCapacity = getCapacity() * 2;

        // Allocate a new array with the expanded capacity
        E[] arr = (E[]) new Comparable[newCapacity];

        // Copy existing active elements into the new array
        for (int index = 0; index < getCapacity(); index++)
            arr[index] = elements[index];

        // Replace the old array element with the new one
        elements = arr;

        // Update capacity
        capacity = newCapacity;
    }


    /**
     * Method that removes the specified element from this set if it is present.
     *
     * @param element the element to be removed from this set
     * @return {@code true} if the set contained the specified element,
     * {@code false} otherwise
     */
    @Override
    public boolean remove(E element) {
        // Return false if the set is empty, the element is null, or the element is not exist
        if (isEmpty() || element == null || !contains(element))
            return false;

        // Find the element by getting the element index
        int elementIndex = getIndexOf(element);

        // Check if the element exist in the array Set
        if (elementIndex < 0)
            return false;

        // Shift subsequent elements to the left
        for (int index = elementIndex; index < count - 1; index++)
            elements[index] = elements[index + 1];


        // Empty the element target index completely who's the last index
        elements[count - 1] = null;

        // decrement the count
        count--;

        return true;
    }

    /**
     * Helper method to finds the index of the target element
     * in the set.
     * <p> Time complexity 0(n), because we check every single element in the Set. </p>
     *
     * @param element the element target to locate in the array
     * @return the index of {@code element} if found, or {@code -1} if not present
     */
    private int getIndexOf(E element) {
        // Scan only populated slots (0 through count - 1) for a match
        for (int index = 0; index < count -1; index++)
            // Return the index as soon as a matching element is found
            if (elements[index].equals(element))
                return index;

        // Element was not found in the set
        return -1;
    }

    /**
     * Checks whether the set contains the specified element target or not
     *
     * @param element the element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element,
     * {@code false} otherwise.
     */
    @Override
    public boolean contains(E element) {
        // Check for null element to avoid storing it in the set
        if (element == null)
            return false;

        // Search for element in the element array
        for (int index = 0; index < count -1; index++)
            if (elements[index].equals(element))
                return true;

        // False for any match
        return false;
    }

    /**
     * Removes all elements from the Set array and resets
     * it to its initial default capacity 10.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        this.capacity = 10;     // Reset the capacity to the default initial size of 10
        this.elements = (E[]) new Comparable[capacity];     // Allocate a new array memory
        this.count = 0;         // Reset the element count to indicate the set is empty
    }


    /**
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        // TODO: Return a SetIterator.
        return null;
    }

    /**
     * Method that return the Set capacity.
     *
     * @return the Set capacity value.
     */
    public int getCapacity() {
        return capacity;
    }

}
