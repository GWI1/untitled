package Les3;
import java.util.Arrays;

public class Main1 {
    static Integer[] arr1 = {1, 2, 5,3,4};
    public static void main(String[] args) {
        Change<Object> change;
        change = new Change<>();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(change.changing(arr1,1,3)));
    }
}