package Kerv.SetProject;

/**
 *
 * @param <E>
 *
 * @author Kerv Paulina
 * @since Mon, Nov 23 2026
 */
public abstract class AbstractSet<E extends Comparable<E>>
implements SetADT<E> {

    protected int count;

    public AbstractSet() {
        // TODO
    }

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param element the element to be added to this set
     * @return {@code true} if the set did not already contain the specified element,
     *         {@code false} otherwise
     */
    @Override
    public abstract boolean add(E element);

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param element the element to be removed from this set
     * @return {@code true} if the set contained the specified element,
     *         {@code false} otherwise
     */
    @Override
    public abstract boolean remove(E element);

    /**
     * Checks whether this set contains the specified element.
     *
     * @param element the element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element,
     *         {@code false} otherwise
     */
    @Override
    public abstract boolean contains(E element);

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Checks whether this set contains no elements.
     *
     * @return {@code true} if this set is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Removes all elements from this set.
     */
    @Override
    public void clear() {

    }

    @Override
    public abstract java.util.Iterator<E> iterator();

}
