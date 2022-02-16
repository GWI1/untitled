package les1;

public class Main {

    public static void main(String[] args) {
        Member[] members = new Member[3];
        members[0]=new Member("Sasha",2000,650);
        members[1]=new Member("Dima",7000,250);
        members[2]=new Member("Masha", 4000,700);
        Team team = new Team("Training", members);

        Course course = new Course(3000,600);
        String result = course.c(team);

        System.out.println(result);
    }


}
