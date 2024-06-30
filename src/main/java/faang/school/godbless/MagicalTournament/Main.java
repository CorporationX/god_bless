package faang.school.godbless.MagicalTournament;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1", 1, 5);
        Task task2 = new Task("Task 2", 2, 10);
        Task task3 = new Task("Task 3", 3, 15);
        Task task4 = new Task("Task 4", 4, 20);
        Task task5 = new Task("Task 5", 5, 25);

        Student garry = new Student("Garry", 2001);
        Student megan = new Student("Megan", 2001);
        Student merry = new Student("Merry", 2002);
        Student sarah = new Student("Sarah", 2002);
        Student bob = new Student("Bob", 2003);
        Student huston = new Student("Huston",2003);
        Student jack = new Student("Jack", 2004);
        Student jane = new Student("Jane", 2005);
        Student mike = new Student("Mike", 2005);

        School school1 = new School("Magic School 1", List.of(garry, megan, merry));
        School school2 = new School("Magic School 2", List.of(sarah, bob, huston));
        School school3 = new School("Magic School 3", List.of(jack, jane, mike));

    }
}
