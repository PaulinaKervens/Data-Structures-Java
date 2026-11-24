package Kerv;

import Kerv.SetProject.SetIterator;
import Kerv.SetProject.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    Student s = new Student(001, "Kerv Paulina", 3.08);
    Student s1 = new Student(002, "karl Paulina", 3.09);


    void main() {
        final var i = 5;
        Integer[] arrayList = {10, 20, 30, 40};


        SetIterator<Integer> iterator = new SetIterator<>(arrayList, 5);



    }
}
