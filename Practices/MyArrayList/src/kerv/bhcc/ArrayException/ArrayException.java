package kerv.bhcc.ArrayException;

public class ArrayException extends Exception {
    public ArrayException() {
        IO.println("ArrayOutOfBounds!!!");
    }
    public ArrayException(final String msg) {
        super(msg);
    }

}
