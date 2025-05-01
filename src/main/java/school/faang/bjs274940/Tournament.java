package school.faang.bjs274940;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Tournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", Difficulty.HARD, 100);
        Task task2 = new Task("Yule Ball Preparations", Difficulty.MEDIUM, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        try {
            allTasks.get();
            log.info("All tasks completed. {} score is {}, {} score is {}",
                    hogwarts.getName(), hogwarts.getTotalPoints(), beauxbatons.getName(), beauxbatons.getTotalPoints());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted: {}", e.getMessage());
        } catch (ExecutionException e) {
            log.error("Execution error: {}", e.getMessage());
        }
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("School {} started task {}", school.getName(), task.getName());
                school.getTeam().forEach(student -> student.addPoints(task.getReward()));
                Thread.sleep(task.getDifficulty().getTime());
                log.info("School {} completed task {}", school.getName(), task.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Task {} for {} was interrupted", task.getName(), school.getName());
            }
            return school;
        });
    }
}
