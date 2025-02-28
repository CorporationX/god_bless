package BJS262410;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 10));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 5));
        School hogwarts = new School(hogwartsTeam, "Hogwarts");
        School beauxbatons = new School(beauxbatonsTeam, "Beauxbatons");

        // Создание заданий
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        // Запуск заданий для школ
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwartsTask.join().getTotalPoints() > beauxbatonsTask.join().getTotalPoints()) {
                        System.out.println("Hogwarts Winner!!");
                    } else {
                        System.out.println("Beauxbatons Winner!!");
                    }
                });
        allTasks.join();
    }
}
