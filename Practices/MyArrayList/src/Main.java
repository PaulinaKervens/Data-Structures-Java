import kerv.bhcc.MyArrayList.MyArrayList;

void main() {
    ArrayList<Integer> arr = new ArrayList<>();

    try {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        IO.println("Capacity is : " + myArrayList.getCapacity());


        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
        myArrayList.add(70);
        myArrayList.add(80);


        IO.println("\nArray data: ");
        myArrayList.print();

        IO.println("\nSize is : " + myArrayList.getSize());
        IO.println("Capacity is : " + myArrayList.getCapacity());


    } catch (Exception arrayException) {
        arrayException.getMessage();
    }


}
