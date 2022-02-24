package Les3;

public class Change <T>{
    T box;
    public T[] changing(T[] arr, int n1, int n2){
        box = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = box;
        return arr;
    }
}