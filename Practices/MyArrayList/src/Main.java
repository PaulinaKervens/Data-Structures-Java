import kerv.bhcc.MyArrayList.MyArrayList;

void main() {
    ArrayList<Integer> arr = new ArrayList<>();

    try {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();


        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
        myArrayList.add(70);
        myArrayList.add(80);
        myArrayList.add(90);

        IO.println(myArrayList.getFirst());

        myArrayList.clear();

        myArrayList.print();

    } catch (Exception arrayException) {
        arrayException.getMessage();
    }


}
