package school.faang.task_50744;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int AWAIT_TERMINATION_TIME = 60;

    public static void main(String[] args) {
        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 1, 100);
        Task task2 = new Task("Yule Ball Preparations", 1, 50);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Tournament tournament = new Tournament();
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, executor);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, executor);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).thenRun(() -> {
            Map<String, Integer> schoolPoints = new HashMap<>();
            schoolPoints.put(hogwarts.getName(), hogwarts.getTotalPoints());
            schoolPoints.put(beauxbatons.getName(), beauxbatons.getTotalPoints());
            getWinner(schoolPoints);
        }).exceptionally((ex) -> {
            log.error(ex.getMessage());
            System.out.println("Победитель не найден!");
            return null;
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static void getWinner(Map<String, Integer> schoolPoints) {
        int maxPoint = schoolPoints.values()
                .stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("schoolPoints is empty"));

        String msg = "Победитель: %s%n";
        schoolPoints.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxPoint))
                .forEach(entry -> System.out.printf(msg, entry.getKey()));
    }
}
