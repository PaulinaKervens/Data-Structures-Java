package LinkedList.src;

import LinkedList.src.kerv.SingleLinkedList.MyLinkedList;

import java.util.LinkedList;

public class SingleLinkedListMain {

    static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<>();
        MyLinkedList<String> m = new MyLinkedList<>("Kervens");
        m.add("Karl");

        for (Object a: m.toArray()) {
            IO.println(a);
        }
    }

}
