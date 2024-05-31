package faang.school.godbless.triwizard.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        List<Student> students1 = List.of(new Student("Anton", 4352, 0)
                , new Student("Dima", 2345, 0)
                , new Student("Peter", 4355, 0));

        List<Student> students2 = List.of(new Student("Dima1", 3456, 0),
                new Student("Anton1", 4567, 0),
                new Student("Peter1", 2345, 0));

        School hogwarts = new School("hogwarts", students1);
        School beauxbatons = new School("beauxbatons", students2);

        Tournament tournament = new Tournament();
        Task task1 = new Task("findSomething", 2, 5);
        Task task2 = new Task("hideFromSomething", 3,10);


        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

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
