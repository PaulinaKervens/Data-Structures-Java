package Kerv.SetProject;

/**
 * Represents a student with an ID, name, and grade point average (GPA).
 * Implements {@link Comparable} interface to sort students in descending order by ID.
 *
 * @author Kerv Paulina
 * @since Mon, Nov 23 2026
 */
public class Student implements Comparable<Student> {

    /** Unique identifier for the student. */
    private int id;

    /** Full name of the student. */
    private String name;

    /** Grade point average of the student. */
    private double gpa;

    /**
     * Constructs a {@code Student} with default attribute values.
     */
    public Student() {
        // Default no-arg constructor
    }

    /**
     * Parameterized constructor that initializes all Student attributes.
     *
     * @param id   the unique identifier for the student
     * @param name the full name of the student
     * @param gpa  the grade point average of the student
     */
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    /**
     * Returns the student's unique identifier.
     *
     * @return the student ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the student's name.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the student's grade point average.
     *
     * @return the student's GPA
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Compares this student to another student in descending order by ID.
     *
     * @param other the other student to compare against
     * @return a negative integer, zero, or a positive integer as this student's ID
     *         is greater than, equal to, or less than the specified student's ID
     */
    @Override
    public int compareTo(Student other) {
        return other.id - this.id;
    }

    /**
     * Returns a formatted string representation of this student's details.
     *
     * @return a string containing the student's ID, name, and GPA
     */
    @Override
    public String toString() {
        // Build the formatted output string using StringBuilder
        StringBuilder result = new StringBuilder("Id: " + getId() + '\n' +
                "Name: " + getName() + '\n' + "GPA: " + getGpa() + " out of 4.00" + '\n');

        // Return it by convert it to a String object
        return result.toString();
    }
}