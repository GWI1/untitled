package Les2;

public class DZ2 {
    public static void main(String[] args) {

try {
    MyArraySizeException.arrayOutOfBonds(2,5);
} catch(ArrayIndexOutOfBoundsException e1){
    System.out.println("Out of bonds exception");
}
    MyArrayDataException.arrayNotInt();

    }
}