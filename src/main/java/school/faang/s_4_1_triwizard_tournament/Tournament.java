package school.faang.s_4_1_triwizard_tournament;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void startTaskEverySchool(List<School> schools, Task task) {
        List<CompletableFuture<School>> schoolsFuture = schools.stream()
                .map(school -> Tournament.startTask(school, task))
                .toList();
        CompletableFuture.allOf(schoolsFuture.toArray(new CompletableFuture[0])).join();
    }

    public static CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().stream()
                    .forEach(student -> student.achievePoints(task.getReward()));
            return school;
        }, executor);
    }

    public static String findWinner(List<School> schools) {
        System.out.println(schools.stream().map(School::getName).toList());
        return schools.stream()
                //.max(Comparator.comparingInt(School::getTotalPoints))
                .sorted(Comparator.comparingInt(School::getTotalPoints).reversed())
                .findFirst()
                .map(School::getName)
                .orElse("No winner");
    }

    public static void shutdown() {
        executor.shutdown();
    }
}