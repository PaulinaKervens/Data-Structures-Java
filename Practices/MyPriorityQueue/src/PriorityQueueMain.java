package MyPriorityQueue.src;


import MyPriorityQueue.src.kerv.PriorityQueue.MyPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueMain {

    static void main(String[] args) {
        PriorityQueue<Integer> m = new PriorityQueue<>();
        m.clear();

        Comparator<Integer> cmp = (o1, o2) -> o1 - o2;

        MyPriorityQueue<Integer, String> myPriorityQueue = new MyPriorityQueue<>(cmp);
        myPriorityQueue.insert(100, "Kervens");
        myPriorityQueue.insert(50, "John Doe");
        myPriorityQueue.insert(70, "Epstein");
        myPriorityQueue.insert(20, "Charlie kiki");
        myPriorityQueue.insert(140, "Bobble");
        myPriorityQueue.insert(180, "Bob");
        myPriorityQueue.insert(120, "La Rose");
        myPriorityQueue.insert(10, "Elton");
        myPriorityQueue.insert(30, "Puff Daddy");
        myPriorityQueue.insert(60, "Donny");
        myPriorityQueue.insert(80, "Capuchino");
        myPriorityQueue.insert(90, "Tum Tum");
        myPriorityQueue.print();
    }

}
