package school.faang.threemagicians;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", Difficulty.HARD, 100);
        Task task2 = new Task("Yule Ball Preparations", Difficulty.EASY, 50);


        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        log.info("Школа {} победила", hogwarts.getName());
                        return;
                    }
                    if (hogwarts.getTotalPoints() < beauxbatons.getTotalPoints()) {
                        log.info("Школа {} победила", beauxbatons.getName());
                        return;
                    }
                    log.info("Победила дружба");
                });

        tournament.terminatedPool();
        allTasks.join();

        log.info("Main остановлен");
    }
}