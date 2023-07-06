package faang.school.godbless.sprint_3.multithreading_future.tournament_of_three_wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> firstSchoolStudents = List.of(new Student("Howard", 17),
                new Student("Mikael", 18),
                new Student("Engie", 19),
                new Student("Matan", 20));
        List<Student> secondSchoolStudents = List.of(new Student("Matt", 19),
                new Student("Murad", 22),
                new Student("Miron", 15),
                new Student("Kolya", 20));
        School firstSchool = new School("Tamlier School", firstSchoolStudents);
        School secondSchool = new School("Gudwin School", secondSchoolStudents);
        Task firstTask = new Task("Handmade soap", 1, 10);
        Task secondTask = new Task("Breathe air", 0, 2);
        Task thirdTask = new Task("Kill Mudzab", 2, 30);
        CompletableFuture<School> firstCompletable = tournament.startTask(firstSchool, thirdTask)
                .thenCompose(school -> tournament.startTask(school, firstTask));
        CompletableFuture<School> secondCompletable = tournament.startTask(secondSchool, thirdTask)
                .thenCompose(school -> tournament.startTask(school, firstTask));
        CompletableFuture.allOf(firstCompletable, secondCompletable)
                .thenRun(() -> {
                    if (firstSchool.getTotalPoints() > secondSchool.getTotalPoints()) {
                        System.out.println("The winner of the magical tournament is " + firstSchool.getName() + " with " + firstSchool.getTotalPoints() + " points.");
                    } else if (secondSchool.getTotalPoints() > firstSchool.getTotalPoints()) {
                        System.out.println("The winner of the magical tournament is " + secondSchool.getName() + " with " + secondSchool.getTotalPoints() + " points.");
                    } else {
                        System.out.println("The magical tournament ended in a tie!");
                    }
                }).join();
    }
}