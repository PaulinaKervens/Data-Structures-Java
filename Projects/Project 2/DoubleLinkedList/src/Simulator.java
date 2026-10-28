/** ****************************************
 * @Author      :   Kerv Paulina
 * @Date        :   Created On :  October 26, 2026  00:27
 * @File        :   Simulator.java
 * @Description :
 *******************************************/


package DoubleLinkedList.src;

import DoubleLinkedList.src.Kerv.DoubleLinkedList.DoubleLinkedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulator {

    /**
     * Attribute that hold the fileData name
     */
    private static final String dataFilename = "Projects/Project 2/DoubleLinkedList/src/Kerv/Data/Commands.csv";
    private static DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();

    /**
     * Main method where the program start.
     *
     * @param args An argument.
     * @throws NoSuchFieldException File exception if file is not found.
     */
    static void main(String[] args) throws NoSuchFieldException {

        // Connect and read the file
        try(Scanner sc = new Scanner(connectFile(dataFilename))) {
            // Read the file until hasNextLine is null
            while (sc.hasNextLine()) {
                // Get each value extracted from the file
                String line = sc.nextLine().trim();

                // Skip empty lines
                if (line.isBlank()) continue;

                // Split the URL from the IP address
                String[] lineSplit = line.split(",");
                // pass the command
                command(lineSplit);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    /**
     * Method that execute each command from the file
     * @param lineSplit Array of string
     */
    private static void command(String[] lineSplit) {
        switch (lineSplit[0]) {
            case "create":
                System.out.println("create");
                break;

            case "insert":
                // Call insert
                linkedList.insert(Integer.valueOf(lineSplit[1]), Integer.valueOf(lineSplit[2]));
                break;

            case ("remove"):
                // todo
                // call remove
                linkedList.remove(Integer.parseInt(lineSplit[1]));
                break;

            case ("get"):
                // todo
                // call getEntry
                linkedList.getEntry(Integer.parseInt(lineSplit[1]));

                break;

            case ("print"):
                IO.println("\n");
                if (Integer.parseInt(lineSplit[1]) == 0) {
                    System.out.println("Print of the list unsorted order:\n" +linkedList);
                } else if (Integer.parseInt(lineSplit[1]) == 1) {
                    linkedList.sort(Comparator.naturalOrder());
                    System.out.println("Print of the list ACS order:\n" + linkedList);
                }
                break;

            default:
                System.out.println("Unknown Command");
        }

    }


    /**
     * Method that connect to the file by taking the filename target.
     *
     * @param filename {@link #dataFilename} to connect.
     * @return true if the file exists, otherwise false.
     */
    private static File connectFile(final String filename) throws NoSuchFieldException {
        // Create the File object to get the file
        File fileConnect = new File(filename);
        System.out.println(fileConnect.getAbsolutePath());
        // Check if the file is connected or not to throw an error
        if (fileConnect.exists())
            return fileConnect;
        else {
            throw new NoSuchFieldException("File's not been found!!!");
        }
    }

}
