package Les2;

public class MyArrayDataException {
    public static void arrayNotInt() {

        String num2[] = {"5", "15", "28", "b", "29" };
        int sum = 0;

            for (int i1 = 0; i1 < num2.length; i1++) {
                try{
                    int a = Integer.valueOf(num2[i1]);

            sum = sum + a;

        }catch(NumberFormatException e2){
                    System.out.println("Array is not int. The exception order is:" +(i1+1));
                }
        }

        System.out.println("The sum is " + sum);

    }
}
