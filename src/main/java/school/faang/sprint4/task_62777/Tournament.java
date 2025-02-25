package school.faang.sprint4.task_62777;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);

    public CompletableFuture<School> startTask(School school, Task task) {
        log.debug("Задача {} дана школе {}", task.name(), school.getName());
        return CompletableFuture.supplyAsync(() -> school.completeTask(task), EXECUTOR);
    }

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6), new Student("Gabrielle", 6));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);


        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenAccept(res -> printWinner(hogwarts, beauxbatons));

        closeExecutor();
    }

    private static void printWinner(School... schools) {
        Arrays.stream(schools)
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(School::getTotalPoints))
                .ifPresentOrElse(
                        school -> System.out.printf("Победитель %s\n", school.getName()),
                        () -> System.out.println("Победителя нет"));
    }

    private static void closeExecutor() {
        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(11, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }
}
