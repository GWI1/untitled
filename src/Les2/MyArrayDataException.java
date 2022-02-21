package Les2;

public class MyArrayDataException {
    public static void arrayNotInt() {

        String num2[] = {"5", "15", "28", " ", "12" };
        int sum = 0;
        for (int i1 = 0; i1 < num2.length; i1++) {
            int a = Integer.valueOf(num2[i1]);

            sum = sum + a;

        }
        System.out.println("The sum is " + sum);

    }
}
