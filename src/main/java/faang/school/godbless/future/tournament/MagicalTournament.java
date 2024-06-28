package faang.school.godbless.future.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MagicalTournament {
    public static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        Tournament tournament = new Tournament();

        Student harryPotter = new Student("Harry Potter", 20, 10);
        Student ronWeasley = new Student("Ron Weasley", 29, 5);
        Student hermioneGranger = new Student("Hermione Granger", 18, 4);
        Student dracoMalfoy = new Student("Draco Malfoy", 31, 9);

        School hogwarts = new School("Hogwarts", List.of(harryPotter, ronWeasley));
        School beauxbatons = new School("Beauxbatons", List.of(hermioneGranger, dracoMalfoy));

        Task task1 = new Task("Defeat the Dark Lord", 5, 1500);
        Task task2 = new Task("Defeat the Necromancer", 10, 2000);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, executorService);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, executorService);

        executorService.shutdown();

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
