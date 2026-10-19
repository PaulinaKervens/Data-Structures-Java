package kerv.bhcc.cache;

import java.util.Objects;

/**
 * DNS cache using an array of cache;
 * Description: This class integrate the Least Recently Used (LRU) data structure,
 * where the most recently used entry is stored at index 0.
 */
public class ArrayCache {

    private CacheEntry[] entries;       // An array of Cache Entry data
    private int numEntries;     // Attribute who hold the exact quantity of cache entered the array
    private int numHits;        // Attribute who hold  the number of times a cache lookup/check was successful.
    private int numMisses;      // Attribute who hold  the number of times a cache lookup/check was failed.


    /**
     * Default Constructor; <br>
     * Creates an ArrayCache with the default capacity of 10 entries by calling the overload constructor. <br>
     * The number of entries, hits, and misses are initialized to zero. <br>
     */
    public ArrayCache() {
        this(10);       // Default constructor call by passing array size (10);
    }

    /**
     * Parametrized Constructor that creates an ArrayCache with the specified capacity.<br>
     * The number of entries, hits, and misses are initialized to zero.
     * @param sz The maximum number of entries the cache can hold.
     */
    public ArrayCache(final int sz) {
        entries = new CacheEntry[sz];
        setNumEntries(0);
        setNumHits(0);
        setNumMisses(0);
    }

    /**
     * Method that add an element to the array. <br>
     * 1) Shifting all element inside the array first if the array has element. <br>
     * 2) Add the element to index 0. <br>
     * 3) Increase the attribute numEntries.
     * @param name The URL
     * @param value The IP address
     */
    public void put(final String name, final String value) {
        // Call the helper method shiftEntries to shift all elements places.
        shiftEntries(entries.length);
        // Add the new entry to the array at index 0
        entries[0] = new CacheEntry(name, value);
        // Let's check if the array is full to increase number cache entered
        // Check if the number cache entered is less than the array size,
        // if no increase the number cache entered + 1, if yes leave it like this
        // because it supposes to be the same size of the array to handle the
        // ArrayIndexOutOfBoundsException
        if (getNumEntries() < entries.length) {
            setNumEntries(getNumEntries() + 1);
        }
    }

    /**
     * This method introduce the <b>LRU</b> method.<br>
     *  <i>1) It gets a name by param who is a target.<br>
     *  2) Then looking for it in the array.<br>
     *  3) If found, it would store it temporary.<br>
     *  4) Shift all others previous values in front of it places.<br>
     *  5) Then place it at index 0, increase numHits by returning the ip address of that name.</i><br>
     * Otherwise, increase misses attribute and return null;<br>
     * @param name The URL of the website.<br>
     * @return  If the URL has been found in the array return it by increase the attribute Hits,<br>
     * Otherwise return null by increase the attribute Misses.<br>
     */
    public String get(final String name) {
        // read the array to find the target name if exists
        for(int index = 0; index <= getNumEntries() - 1; index++) {
            // Using object class with equals method to handles null exception.
            if (Objects.equals(name, entries[index].getName())) {
                // Create a temporary array to hold the value found
                // to do not overite it or overite another value either
                CacheEntry temp = entries[index];
                // Call the helper to shift all elements before the target.
                // increase the index by one because the helper starts at endIdx - 1.
                shiftEntries(index + 1);
                // Assign the temp value found to the index 0
                entries[0] = temp;
                // Increase the attribute hit because we found the target
                setNumHits(getHits() + 1);
                // Return the value
                return temp.getValue();
            }
        }
        // Increase the misses because the target was not found.
        setNumMisses(getMisses() + 1);
        // Return the null
        return null;
    }


    /**
     * This method is a helper method that take a value index in param,
     * then shift all these elements places.
     * @param endIdx The index to start shifting element.
     */
    private void shiftEntries(final int endIdx) {
        // Let's shift all element from left to right so we can overwrite
        // the last entry when the array is full by using a backward loop.
        // As array start with 0 decrease the endIdx value before to avoid ArrayIndexOutOfBoundsException
        for (int index = endIdx - 1; index >= 1; index--) {
            entries[index] = entries[index - 1]; // Shift each existing entry one position to the right.
        }
    }

    /**
     * Method that clear the cache array;
     */
    public void clear() {
        setNumEntries(0);
        setNumHits(0);
        setNumMisses(0);
    }

    // Method that check if the array is empty or not
    public boolean isEmpty() { return getNumEntries() == 0; }

    /** Accessor **/
    public int getHits() { return numHits; }
    public int getMisses() { return numMisses; }
    public int getNumEntries() { return numEntries; }

    /** Mutator **/
    private void setNumMisses(final int numMisses) { this.numMisses = numMisses; }
    private void setNumHits(final int numHits) { this.numHits = numHits; }
    private void setNumEntries(final int numEntries) { this.numEntries = numEntries; }


    /**
     * To string method.
     * @return A string of object;
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\nEntries: " + getNumEntries() + "\n" +
                "   Hits: " + getHits() + "\n" +
                " Misses: " + getMisses() + "\n");

        // Read the loop to extract each element name and value
        for (int index = 0; index < getNumEntries(); index++) {
            // Concatenate the value found to the string
            result.append(entries[index]).append("\n");
        }
        return result.toString();      // Return the string
    }


}
