package school.faang.stream4.triwizardtournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<CompletableFuture<School>> futures = new ArrayList<>();

        futures.add(tournament.startTask(hogwarts, task1, executor));
        futures.add(tournament.startTask(beauxbatons, task2, executor));
        futures.add(tournament.startTask(beauxbatons, task1, executor));
        futures.add(tournament.startTask(hogwarts, task2, executor));
        futures.add(tournament.startTask(hogwarts, task1, executor));

        Map<String, Long> schoolPoints = new HashMap<>();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    schoolPoints.put(hogwarts.getName(), hogwarts.getTotalPoints());
                    schoolPoints.put(beauxbatons.getName(), beauxbatons.getTotalPoints());

                    long maxPoints = schoolPoints
                            .values().stream()
                            .max(Long::compare).orElse(0L);
                    String winnerName = schoolPoints.entrySet()
                            .stream()
                            .filter(entry -> entry.getValue() == maxPoints)
                            .map(Map.Entry::getKey)
                            .findFirst().orElse("");

                    System.out.printf("Школа - победитель: %s набрала %d очков\n", winnerName, maxPoints);
                });

        allTasks.join();
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (
                InterruptedException e) {
            System.out.println(e + " - завершение пула потоков прервано");
            executor.shutdownNow();
        }
    }
}
