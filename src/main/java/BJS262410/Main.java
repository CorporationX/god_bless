package BJS262410;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 10));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 5));
        School hogwarts = new School(hogwartsTeam, "Hogwarts");
        School beauxbatons = new School(beauxbatonsTeam, "Beauxbatons");

        // Создание заданий
        Task firstTask = new Task("Triwizard Tournament", 10, 100);
        Task secondTask = new Task("Yule Ball Preparations", 5, 50);

        // Запуск заданий для школ
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, firstTask);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, secondTask);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwartsTask.join().getTotalPoints() > beauxbatonsTask.join().getTotalPoints()) {
                        log.info("Hogwarts Winner!!");
                    } else {
                        log.info("Beauxbatons Winner!!");
                    }
                });
        allTasks.join();
    }
}
