package Les3;

public class Main2 {

    public static void main(String[] args) {

        Apples[] a01 = new Apples[10];
        Apples a0=new Apples(1.0f);
        Apples a1=new Apples(1.0f);
        Apples a2=new Apples(1.0f);
        Apples a3=new Apples(1.0f);

        a01[0]=a0;
        a01[1]=a1;
        a01[2]=a2;

        Box<Apples>box1=new Box<>(a01);
        Apples[]a02=new Apples[10];
        a02[0]=a0;
        a02[1]=a1;
        a02[2]=a2;
        a02[3]=a3;

        Box<Apples>box2=new Box<>(a02);

        System.out.println(box1.compare(box2));
        box1.process(box2);

        Oranges[] orange = new Oranges[10];
        Oranges o0=new Oranges(1.5f);
        Oranges o1=new Oranges(1.5f);
        Oranges o2=new Oranges(1.5f);
        Oranges o3=new Oranges(1.5f);
        Oranges o4=new Oranges(1.5f);
        orange[0]=o0;
        orange[1]=o1;
        orange[2]=o2;
        orange[3]=o3;
        orange[4]=o4;

        Box<Oranges> box3 = new Box<>(orange);
        System.out.println(box1.compare(box3));
    }
}
