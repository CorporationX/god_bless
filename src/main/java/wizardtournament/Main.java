package wizardtournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, executorService);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, executorService);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            School winner = hogwarts.getTotalPoints() > beauxbatons.getTotalPoints() ? hogwarts : beauxbatons;
            System.out.printf("%s побеждает в турнире. \n", winner.getName());
        });

        allTasks.join();
        executorService.shutdown();
    }
}
