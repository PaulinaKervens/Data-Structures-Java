package _3_MyStack.src.kerv;

import _3_MyStack.src.kerv.MyStack.MyStack;

public class Main {

    static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        IO.println("My stack: ");

        for (int i : myStack) {
            IO.println(i);
        }

        IO.println(myStack.search(3));
    }
}
