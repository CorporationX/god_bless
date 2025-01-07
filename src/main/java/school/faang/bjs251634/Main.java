package school.faang.bjs251634;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import school.faang.bjs251634.model.School;
import school.faang.bjs251634.model.Student;
import school.faang.bjs251634.model.Task;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            log.info("All tasks are completed");
            try {
                log.info("Hogwarts total points: {}", hogwartsTask.get().getTotalPoint());
                log.info("Beauxbatons total points: {}", beauxbatonsTask.get().getTotalPoint());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Error occurred while getting the total points", e);
            } catch (ExecutionException e) {
                log.error("Error occurred while getting the total points", e);
            }
        }).get();
    }
}
