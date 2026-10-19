// Program name: LRU - Cache simulator
// Programmer: (Kerv) Kervens Paulina
// Date : October 3, 2026
// End  : October 8, 2026


package kerv.bhcc.cache;

import java.io.File;                    // Import the File class
import java.io.FileNotFoundException;   // Import this class to handle errors
import java.util.Scanner;               // Import the Scanner class to read text files


/**
 * Simulates at Least Recently Used (LRU) DNS cache.
 * The simulator reads DNS queries from a file, checks whether
 * the requested website is already in the cache, and adds it
 * to the cache when it is not found.
 */
public class Simulator {
    private String cacheFileName;
    private int cacheSize;
    private ArrayCache arrayCache;
    private final Scanner sc = new Scanner(System.in);


    /**
     * Starts the cache simulator.
     * Prompts the user for a query file and a positive cache size,
     * runs the simulation, and displays the cache Hit and Miss rates.
     *
     * @param args command-line arguments
     * @throws FileNotFoundException if the query file cannot be found
     */
    public static void main(String[] args) throws FileNotFoundException {
        Simulator simulator = new Simulator();

        // Get the filename from user
        simulator.getCacheFileName();

        // Get the cache size
        simulator.getCacheSize();

        // setCacheSize(sc.nextInt());
        simulator.simulate(simulator.arrayCache, simulator.cacheFileName);

        // Print the statistics
        simulator.printStats(simulator.arrayCache);
    }



    /**
     * Method that read the file, split the content and add it to an array <br>
     * then, call the add() method helper to add the content to the ArrayCache.
     * @throws FileNotFoundException if the query file cannot be found.
     */
    public void simulate(final ArrayCache arrayCache, final String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/kerv/bhcc/database/" + filename))) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine().trim();

                // Skip empty lines
                if (line.isBlank()) continue;

                // Split the URL from the IP address
                String[] lineSplit = line.split(":");

                // Try to get the URL from the cache.
                // If it is not found, add it to the cache.
                add(arrayCache, lineSplit[0], lineSplit[1]);

                // Print the cache after processing the line
                System.out.println(arrayCache);
            }
        }
    }

    /**
     * Helper method that adds an element to the ArrayCache only if it does not exist.
     * Null == not exists, any other value == exists.
     * @param arrayCache The ArrayCache used for the simulation.
     * @param name The URL of a website.
     * @param value The IP address.
     */
    private void add(final ArrayCache arrayCache, final String name, final String value) {
        // Check if the URL already exists in the cache.
        String cachedValue = arrayCache.get(name);

        // If the URL is not in the cache, add it.
        if (cachedValue == null) {
            arrayCache.put(name, value);
        }
    }

    // Method that print the statistic of miss and hit
    public void printStats(final ArrayCache arrayCache) {
        // Hit Rate  = hits / (hits + misses) * 100
        System.out.printf(" Hit Rate: %.2f%%%n",  ((double) arrayCache.getHits() / (arrayCache.getHits() + arrayCache.getMisses()) * 100));
        // Miss Rate = misses / (hits + misses) * 100
        System.out.printf("Miss Rate: %.2f%%%n", ((double) arrayCache.getMisses() / (arrayCache.getHits() + arrayCache.getMisses()) * 100));
    }


    /**
     * Helper method to get an exist file name from user.
     */
    private void getCacheFileName() {
        do {
            System.out.print("Please enter query file name: ");
            // Read from input user
            cacheFileName = sc.next().trim();
        } while(!connectFile(cacheFileName));
    }

    /**
     * Method that connect to the file by taking the filename target.
     * @param filename The filename to connect to
     * @return true if the file exists, otherwise false.
     */
    private boolean connectFile(final String filename) {
        // Create the File object to get the file
        File fileConnect = new File("src/kerv/bhcc/database/" + filename);
        // Check if the file is connected or not to throw an error
        if (fileConnect.exists())
            return true;
        else {
            System.out.println("File name was not found.");
            return false;
        }
    }


    /**
     * Helper method to get a positive number from user.
     */
    private void getCacheSize() {
        // Loop to get a positive number from user
        do {
            System.out.print("Please enter a positive cache size: ");
            cacheSize = sc.nextInt();       // Read the cache size from input user.
        } while (cacheSize <= 0);
        // Set the size to the array
        setArrayCache(cacheSize);
    }

    /**
     * Helper method to initialise the ArrayCache size
     * @param cacheSize The size of the Array from setCacheSize.
     */
    private void setArrayCache(final int cacheSize) { this.arrayCache = new ArrayCache(cacheSize); }

}
