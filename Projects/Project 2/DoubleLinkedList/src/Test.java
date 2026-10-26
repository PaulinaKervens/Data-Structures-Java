package DoubleLinkedList.src;

import DoubleLinkedList.src.Kerv.DoubleLinkedList.DoubleLinkedList;
import DoubleLinkedList.src.Kerv.DoubleNode.DoubleNode;

public class Test {

    public static void print(DoubleLinkedList<Integer> list) {
        for(int i = 0; i < list.getLength(); i++)
            IO.println(list[i]);
    }

    public static void main(String[] args) {
       /* DoubleNode<Integer> doubleNode = new DoubleNode<>();
        IO.println(doubleNode);

        doubleNode.setItems(1);
        doubleNode.setItems(2);
        doubleNode.setItems(3);
        doubleNode.setItems(4556);

        IO.println(doubleNode);
*/

        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.insert(1,10);
        doubleLinkedList.insert(2,20);
        doubleLinkedList.insert(3,30);
        doubleLinkedList.insert(4,40);

        doubleLinkedList.remove(2);
        print(doubleLinkedList);

        IO.println(doubleLinkedList);
        //IO.println("Entry at position 3 : " + doubleLinkedList.getEntry(5));
        //IO.println("Position of entry 30 : " + doubleLinkedList.getIndexOf(30));
        //IO.println("My doubleLinkedList isEmpty: " + doubleLinkedList.isEmpty());
       // IO.println("My doubleLinkedList length: " + doubleLinkedList.getLength());


    }

}
