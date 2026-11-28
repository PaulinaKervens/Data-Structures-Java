package Kerv;

import Kerv.SetProject.ArraySet;
import Kerv.SetProject.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *  @Author : Kerv Paulina
 *  @since Fri, Nov 27 2026
 *  @File : Main.java
 *  Description: The main class, the entry
 *               point of the program.
 */
public class Main {
    /** Attribute that hold the fileData name */
    //private final String filename = "src/Kerv/Data/Student.txt";
    private final String filename = "Projects/Project 3/SetProject/src/Kerv/Data/Student";


    /**
     * Main method where the program starts.
     *
     * @param args An argument.
     * @throws FileNotFoundException File exception if file is not found.
     */
     static void main(String[] args) throws FileNotFoundException {

        // Create an object
        Main m = new Main();

        // Read the file content and run it
        m.runner(m.readFile(m.filename));
    }


    /**
     * Method that processes the student records.
     *
     * @param data Student records extracted from the file.
     */
    public void runner(String[] data) {
        ArraySet<Student> students = new ArraySet<>();
        int id;
        double gpa;
        String name;

        // Read the data array
        for (int index = 0; index < data.length; index++) {
            // Split each student record into individual values
            String[] studentData = data[index].split(",");

            // Validate the student record,
            // where a student suppose to have an id, name, gpa
            if (studentData.length != 3) {
                System.out.println("Invalid student record: " + data[index]);
                continue;
            }

            try {
                // Get the id part
                id = Integer.parseInt(studentData[0].trim());
                // Get the name part
                name = studentData[1].trim();
                // Get the gpa
                gpa = Double.parseDouble(studentData[2].trim());

                // Create a new student object and
                // Add student to the set.
                students.add(new Student(id, name, gpa));

            } catch (NumberFormatException e) {
                System.out.println("Invalid student data: " + data[index]);
            }

        }

        // Display all students
        System.out.println("\nDisplay all students");
        System.out.println("-----------------------------------");
        System.out.println(students);

        // Display using enhanced for-loop
        System.out.println("\n\n" + "Display using enhanced for-loop");
        System.out.println("-----------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }

        // print the total of student
        System.out.println("\nTotal students: " + students.size());

        // Print the array student capacity
        System.out.println("Array capacity: " + students.getCapacity());

        // Search for student ID 1005
        System.out.println("Search student ID 1005: " + students.contains(new Student(1005, "", 0.0)));

        // Remove student ID 1003
        students.remove(new Student(1003, "", 0.0));

        // Display the set again
        System.out.println("\n\n" + "Students after removal:");
        System.out.println("-----------------------------------");
        // Display using enhanced for-loop
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\nTotal students: " + students.size());

    }



    /**
     * Method that reads the file data.
     *
     * @param filename {@link #filename} to connect.
     * @return An array containing all student records.
     * @throws FileNotFoundException Exception if the file does not exist.
     */
    public String[] readFile(final String filename) throws FileNotFoundException {
        // Create a collection to store file records
        ArrayList<String> records = new ArrayList<>();

        // Connect and read the file
        try (Scanner scanner = new Scanner(connectFile(filename))) {

            // Read the file until there are no more lines
            while (scanner.hasNextLine()) {
                // Get each value extracted from the file
                String line = scanner.nextLine().trim();

                // Skip empty lines
                if (line.isBlank()) continue;

                // Store each student record
                records.add(line);
            }
        }

        return records.toArray(new String[0]);
    }



    /**
     * Method that connects to the file by taking the filename target.
     *
     * @param filename {@link #filename} to connect.
     * @return The File object if it exists.
     * @throws FileNotFoundException Exception if the file does not exist.
     */
    private static File connectFile(String filename) throws FileNotFoundException {
        File fileToConnect = new File(filename);

        // Check if the file exists
        if (fileToConnect.exists() && fileToConnect.isFile()) {
            return fileToConnect;
        }

        // throw an exception
        throw new FileNotFoundException("File has not been found!" + fileToConnect.getAbsoluteFile());
    }
}

