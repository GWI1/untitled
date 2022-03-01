package Les4;

import java.util.HashMap;

public class Main2 {
    public static HashMap<String,String>book=new HashMap<>();
    public static void main(String[] args){
        add("123","1");
        add("124","1");
        add("125","2");
        add("126","1");
        add("127","2");
        System.out.println(get("1"));

    }

    public static void add(String n,String name) {
        book.put(n,name);
    }

    public static String get(String name){
        if (book.containsValue(name)){
            String total=" ";
                for (String n1: book.keySet()) {
                    if (book.get(n1).equals(name))
                        total = total + " " + n1;
                }
                return (name+" has numbers:"+total);


            }else {
                return (name+" has numbers: n/a");
            }
    }
}


