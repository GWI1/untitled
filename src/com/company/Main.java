package com.company;

public class Main {

    public static void main(String[] args) {
        Member[] members = {new Member("Sasha",2000,650), new Member("Dima",7000,250), new Member("Masha", 4000,700)};
        Team team = new Team("Training", members);

        Course course = new Course(3000,600);
        String result = course.c(team);

        System.out.println(result);
    }
}
