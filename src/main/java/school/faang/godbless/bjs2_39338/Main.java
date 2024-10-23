package school.faang.godbless.bjs2_39338;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        Task task1 = new Task("Triwizard Tournament", 1000, 100);
        Task task2 = new Task("Yule Ball Preparations", 5000, 50);
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1)
                .whenComplete((School school, Throwable throwable) -> {
                    if (throwable != null) {
                        handleException(school, throwable);
                    }
                });
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2)
                .whenComplete((School school, Throwable throwable) -> {
                    if (throwable != null) {
                        handleException(school, throwable);
                    }
                });
        School winner = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).thenApply(v -> {
                    School hogwartsResult = hogwartsTask.join();
                    School beauxbatonsResult = beauxbatonsTask.join();
                    if (hogwartsResult.getTotalPoints() > beauxbatonsResult.getTotalPoints()) {
                        return hogwartsResult;
                    }
                    return beauxbatonsResult;
                }
        ).join();
        log.info("The winner is {}", winner.getName());
    }

    private static void handleException(School school, Throwable ex) {
        log.error("Failed to complete task for school {} : {}", school.getName(), ex.getMessage());
    }
}
