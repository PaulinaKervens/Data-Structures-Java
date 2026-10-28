package DoubleLinkedList.src.Kerv;

import DoubleLinkedList.src.Kerv.DoubleLinkedList.DoubleLinkedList;

import java.util.Comparator;

public class Test {

    DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();

    void main(String[] args) {
        doubleLinkedList.insert(1, "Kervens");
        doubleLinkedList.insert(2, "Cherry");
        doubleLinkedList.insert(2, "Banana");
        doubleLinkedList.insert(3, "potato");

        doubleLinkedList.sort(Comparator.naturalOrder());
        IO.println(doubleLinkedList);
        IO.println(doubleLinkedList.getLength());
    }
}
