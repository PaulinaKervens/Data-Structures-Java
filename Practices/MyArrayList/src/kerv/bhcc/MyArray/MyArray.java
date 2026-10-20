package kerv.bhcc.MyArray;

import java.util.ArrayList;

public class MyArray<E> {

    private E[] elements;                   // Attribute for the array which is a static allocated array
    private int size;                       // The array size
    private int capacity;                   // The array capacity

    public MyArray(final int capacity) {
        elements = (E[]) new Object[capacity];

    }

    public void setCapacity(int capacity) { this.capacity = capacity; }



}
