package faang.school.godbless.threewizardstournament3133;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final List<School> SCHOOLS = createSchoolsList();
    static final List<Task> TASKS = createTasksList();
    static final List<CompletableFuture<School>> TOURNAMENT_FUTURE_RESULT = new ArrayList<>();
    static final Tournament TOURNAMENT = new Tournament();
    static final ExecutorService TASK_EXECUTOR = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        SCHOOLS.forEach(school ->
                TASKS.forEach(task ->
                        TOURNAMENT_FUTURE_RESULT.add(TOURNAMENT.startTask(school, task, TASK_EXECUTOR))));

        CompletableFuture.allOf(TOURNAMENT_FUTURE_RESULT.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    System.out.println("All the participants are: ");
                    SCHOOLS.forEach(school -> System.out.printf("%s - %d points%n", school.getName(), school.getTotalPoints()));
                    System.out.println(getTournamentWinner());
                });
        shutDownAndWait();
    }

    private static void shutDownAndWait() {
        TASK_EXECUTOR.shutdown();
        try {
            TASK_EXECUTOR.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static School getTournamentWinner() {
        System.out.println("""
                =====================
                * AND THE WINNER IS *
                =====================""");
        return SCHOOLS.stream()
                .sorted(Comparator.comparingInt(School::getTotalPoints).reversed())
                .toList()
                .get(0);
    }

    private static List<School> createSchoolsList() { // not quite fits the story. Itches me a lot >.<
        return new ArrayList<>(List.of(
                new School("Durmstrang", new ArrayList<>(List.of(
                        new Student("Viktor Krum", 7, 0),
                        new Student("Igor Kararoff", 7, 0),
                        new Student("Boryan Bogdanovich", 6, 0)
                ))),
                new School("Hogwarts", new ArrayList<>(List.of(
                        new Student("Harry Potter", 4, 0),
                        new Student("Cedric Diggory", 6, 0),
                        new Student("Some Guy", 7, 0)
                ))),
                new School("Beauxbatons", new ArrayList<>(List.of(
                        new Student("Fleur Delacour", 6, 0),
                        new Student("Gabriel Delacour", 6, 0),
                        new Student("Olymp Delacour", 7, 0)
                )))));
    }

    private static List<Task> createTasksList() {
        return new ArrayList<>(List.of(
                new Task("Get the dragon egg", 4, 40),
                new Task("Save the prisoner", 7, 45),
                new Task("Find the trophy in the Labyrinth", 9, 25) // we all knew what happened
        ));
    }
}
