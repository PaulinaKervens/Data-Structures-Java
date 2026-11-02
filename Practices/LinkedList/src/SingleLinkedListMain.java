package LinkedList.src;

import LinkedList.src.kerv.SingleLinkedList.MyLinkedList;

import java.util.LinkedList;

public class SingleLinkedListMain {

    static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<>();


        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);

        myLinkedList.removeLast();


        for (Object a: myLinkedList.toArray()) {
            IO.println(a);
        }
    }

}
