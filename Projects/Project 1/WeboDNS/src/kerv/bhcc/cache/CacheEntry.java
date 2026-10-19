package kerv.bhcc.cache;

/**
 * Represents an entry in the DNS cache.
 * Each entry contains a website name and its IP address.
 */
public class CacheEntry {
    private String name;   // Attribute for the website name.
    private String value;  // Attribute for the ip address.

    /**
     * Parametrized constructor. <br>
     * Creates a new cache entry with a website name and IP address. <br>
     * @param name The website name
     * @param value It owns value which is the Internet Protocol (IP address).
     */
    public CacheEntry(final String name, final String value) {
        setName(name);      // set the name
        setValue(value);    // set the ip address
    }

    /**
     * Returns The website name stored in this cache entry.
     * @return The website name
     */
    public String getName() { return name; }

    /**
     * Returns The IP address stored in this cache entry.
     * @return The IP address
     */
    public String getValue() { return value; }

    /**
     * Updates the website name of this cache entry.
     * @param name The new website name
     */
    public void setName(final String name) { this.name = name; }

    /**
     * Updates the IP address of this cache entry.
     * @param value The new IP address
     */
    public void setValue(final String value) { this.value = value; }


    /**
     * Returns a string representation of this cache entry,
     * including its website name and IP address.
     * @return The formatted string containing the name and value.
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\t" + "Value: " + getValue();
    }
}
