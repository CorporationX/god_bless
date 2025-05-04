package school.faang.bjs274891;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<School> schools = List.of(
                new School("Hogwarts", List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0))),
                new School("Beauxbatons", List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0))),
                new School("Faang", List.of(new Student("Vlad", 6, 0), new Student("Misha", 7, 0)))
        );

        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", 10, 100),
                new Task("Yule Ball Preparations", 5, 50),
                new Task("Toilet cleaning", 7, 70)
        );

        List<CompletableFuture<School>> schoolTaskFutures = new ArrayList<>();
        for (int i = 0; i < schools.size(); i++) {
            schoolTaskFutures.add(tournament.startTask(schools.get(i), tasks.get(i)));
        }

        CompletableFuture<Void> allTasks =
                CompletableFuture.allOf(schoolTaskFutures.toArray(new CompletableFuture[schoolTaskFutures.size()]));

        allTasks.thenRun(() -> {
            try {
                List<School> finishedSchools = new ArrayList<>();
                for (CompletableFuture<School> future : schoolTaskFutures) {
                    finishedSchools.add(future.get());
                }

                School winner = finishedSchools.stream()
                        .max(Comparator.comparingInt(school ->
                                school.getTeam().stream()
                                        .mapToInt(s -> s.getPoints())
                                        .sum()
                        ))
                        .orElseThrow();

                System.out.println("Победители " + winner.getName());

            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        });

        try {
            allTasks.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        tournament.getExecutorService().shutdown();
    }
}

