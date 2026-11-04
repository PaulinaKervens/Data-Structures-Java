package LinkedList.src;

import LinkedList.src.kerv.DoublyLinkedList.MyLinkedList;

import java.util.LinkedList;

public class DoublyLinkedListMain {

    static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);

        for (Object a: myLinkedList.toArray()) {
            IO.println(a);
        }
    }

}
