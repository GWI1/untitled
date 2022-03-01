package Les4;

import java.util.HashMap;

public class Main2 {
    public static HashMap<String,String>book=new HashMap<>();
    public static void main(String[] args){
        add("123","1");
        add("124","1");
        add("125","2");
        add("126","1");
        System.out.println(get("1"));

    }

    public static void add(String n,String name) {
        book.put(n,name);
    }

    public static String get(String name){
        for (String n1: book.keySet()){
            if (book.containsValue(name)){
                return (name+" has numbers: "+book.keySet());
        }else return (name+" n/a");

        }return name;
    }
}
