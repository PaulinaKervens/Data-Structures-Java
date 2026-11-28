package Kerv.SetProject;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Class that implement the iterator to traverses the array from the first element to the last.
 * Implements {@link Iterator} interface to make the Set class iterable.
 *
 * @param <E> The element type.
 * @author Kerv Paulina
 * @since Mon, Nov 23 2026
 */
public class SetIterator<E> implements Iterator<E> {

    /** Array backing the set elements being iterated over */
    private E[] elements;

    /** Index of the element to return during iteration */
    private int current;

    /** The number of elements in the set */
    private int size;

    /**
     * Constructs a {@code SetIterator} over the specified element array
     *
     * @param elements the array backing the set elements
     * @param size     the number of active elements in the set
     * @throws IllegalArgumentException if {@code elements} is {@code null}, or {@code size} is negative
     */
    public SetIterator(E[] elements, int size) {
        // Validate that the backing array is non-null and contains at least one element
        if (elements == null || size < 0)
            throw new IllegalArgumentException(
                    "Elements cannot be null and size cannot be negative"
            );

        this.elements = elements;
        this.size = size;
        this.current = 0;
    }


    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        // Index of the next element to return
        return current < size;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        // Throw NoSuchElementException if no element remains.
        if (!hasNext())
            throw new NoSuchElementException(
                    "No more element in the array"
            );

        // Return the next element and Advance current.
        return elements[current++];
    }

}
