package Les4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main1 {
    public static ArrayList<String> words = new ArrayList<>(20);

    public static void main(String[] args) {
        fillArrayList();
        System.out.println("Words0= " + words.size());
        HashSet<String> hashSet = new HashSet<String>(words);
        System.out.println("Words1=  " + hashSet.size());

        HashMap<String,Integer> total = new HashMap<>();
        for(String w: hashSet){
            total.put(w,number(w));
        }
        System.out.println(total);
    }
    public static Integer number(String w){
        Integer total = 0;
        for(String w1 : words){
            if(w1.equals(w))
                total++;
        }
        return total;
    }

    public static void fillArrayList(){
        words.add("одну");
        words.add("простую");
        words.add("сказку");
        words.add("а");
        words.add("может");
        words.add("и");
        words.add("не");
        words.add("сказку");
        words.add("а");
        words.add("может");
        words.add("не");
        words.add("простую");
        words.add("хотим");
        words.add("вам");
        words.add("рассказать");
        words.add("её");
        words.add("мы");
        words.add("помним");
        words.add("с");
        words.add("детства");
        words.add("а");
        words.add("может");
        words.add("и");
        words.add("не");
        words.add("с");
        words.add("детства");
        words.add("а");
        words.add("может");
        words.add("и");
        words.add("не");
        words.add("помним");
        words.add("но");
        words.add("будем");
        words.add("вспоминать");
    }
}







