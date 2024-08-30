package faang.school.godbless.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Task mainTask = new Task("Duel with Basilisk", 3, 15);

        Student st1 = new Student("First", 18);
        Student st2 = new Student("Second", 19);
        Student st3 = new Student("Third", 18);
        Student st4 = new Student("Fourth", 20);

        List<Student> firstTeam = new ArrayList<>(List.of(st1, st2));
        List<Student> secondTeam = new ArrayList<>(List.of(st3, st4));

        School school1 = new School(firstTeam, "First School");
        School school2 = new School(secondTeam, "Second School");

        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask = tournament.startTask(school1, mainTask);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(school2, mainTask);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            try {
                School completedSchool1 = hogwartsTask.get();
                School completedSchool2 = beauxbatonsTask.get();

                if (completedSchool1.getTotalPoints() > completedSchool2.getTotalPoints()) {
                    System.out.println("The winner of the magical tournament is " + completedSchool1.getName()
                            + " with " + completedSchool1.getTotalPoints() + " points.");
                } else if (completedSchool2.getTotalPoints() > completedSchool1.getTotalPoints()) {
                    System.out.println("The winner of the magical tournament is " + completedSchool2.getName()
                            + " with " + completedSchool2.getTotalPoints() + " points.");
                } else {
                    System.out.println("The magical tournament ended in a tie!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).join();
    }
}
