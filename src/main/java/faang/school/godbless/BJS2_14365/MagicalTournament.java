package faang.school.godbless.BJS2_14365;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");

        Student s1 = new Student("Student1", 1, 2);
        Student s2 = new Student("Student2", 2, 1);
        Student s3 = new Student("Student3", 2, 4);
        Student s4 = new Student("Student4", 1, 6);
        Student s5 = new Student("Student5", 3, 9);
        Student s6 = new Student("Student6", 2, 10);
        Student s7 = new Student("Student7", 3, 3);
        Student s8 = new Student("Student8", 1, 3);
        Student s9 = new Student("Student9", 1, 5);
        Student s10 = new Student("Student10", 3, 4);
        Student s11 = new Student("Student11", 4, 2);
        Student s12 = new Student("Student12", 2, 1);
        hogwarts.addStudentsToSchool(s1, s2, s3, s7, s11, s12);
        beauxbatons.addStudentsToSchool(s4, s5, s6, s10, s8, s9);
        Task quiddich = new Task("Quiddich", 25, 200);
        Task magic = new Task("Magic", 5, 35);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, magic);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, quiddich);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
