package school.faang.task_50708;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tournament tournament = new Tournament();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 5, 100);
        Task task2 = new Task("Yule Ball Preparations", 2, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, executorService);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, executorService);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Error : " + exception.getMessage());
            } else {
                try {
                    int resultHogwarts = hogwartsTask.get().getTotalPoints();
                    int resultBeaux = beauxbatonsTask.get().getTotalPoints();
                    System.out.println(resultHogwarts);
                    System.out.println(resultBeaux);
                    if (resultHogwarts > resultBeaux) {
                        System.out.println("Hogwarts win!");
                    } else if (resultHogwarts < resultBeaux) {
                        System.out.println("Hogwarts lose!");
                    } else {
                        System.out.println("Draw");
                    }
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        allTasks.join();
        executorService.shutdown();
    }
}