package Les2;

public class DZ2 {
    public static void main(String[] args) {
        String[][] arr1 = {{"9", "25", "0", "16" }, {"2", "55", "32", "1" }, {"5", "29", "8", "m6" }, {"12", "8", "62", "10" }};
        String[][] arr2 = {{"15", "25", "18", "16" }, {"2", "84", "32", "1" }};
        try {
            System.out.println(sum(arr1));
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(isBond4x4(arr2));
        } catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        }
    }
        static String isBond4x4(String[][]arr2) throws MyArraySizeException {
            if (arr2.length != 4 || arr2[0].length != 4) throw new MyArraySizeException("Size Error");
                return "The array is 4x4";

            }
        static String sum(String arr1[][]) throws MyArrayDataException{
                    int s=0;
                    for (int i=0;i<arr1.length;i++){
                        for (int j=0;j<arr1[0].length;j++){
                            try {
                                s = s + Integer.valueOf(arr1[i][j]);
                            }catch (NumberFormatException e){
                                throw new MyArrayDataException("The element ["+(i+1)+"]["+(j+1)+"] is exceptional");
                            }
                        }
                    }
                    return ("The sum of elements is "+s);

                }
    }
        class MyArraySizeException extends Exception {
            public MyArraySizeException(String error1) {
                super(error1);
            }
        }
        class MyArrayDataException extends Exception {
            public MyArrayDataException(String error2){
                super(error2);
            }
        }








