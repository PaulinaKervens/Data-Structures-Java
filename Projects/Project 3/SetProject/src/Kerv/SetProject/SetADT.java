package Kerv.SetProject;

/**
 * Abstract data type representing a collection of unique elements of type {@code E}
 * with no duplicate entries. Extends {@link Iterable} to allow element traversal.
 *
 * @param <E> the type of elements maintained by this set
 * @author Kerv Paulina
 * @since Mon, Nov 23 2026
 */
public interface SetADT<E> extends Iterable<E> {

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param element the element to be added to this set
     * @return {@code true} if the set did not already contain the specified element,
     *         {@code false} otherwise
     */
    boolean add(E element);

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param element the element to be removed from this set
     * @return {@code true} if the set contained the specified element,
     *         {@code false} otherwise
     */
    boolean remove(E element);

    /**
     * Checks whether this set contains the specified element.
     *
     * @param element the element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element,
     *         {@code false} otherwise
     */
    boolean contains(E element);

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    int size();

    /**
     * Checks whether this set contains no elements.
     *
     * @return {@code true} if this set is empty, {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Removes all elements from this set.
     */
    void clear();

}