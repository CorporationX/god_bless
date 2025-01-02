package school.faang.task_51119;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    try {
                        School hogwartsTaskResult = hogwartsTask.get();
                        School beauxbatonsTaskResult = beauxbatonsTask.get();

                        log.info(
                                "{} total points {}",
                                hogwartsTaskResult.getName(),
                                hogwartsTaskResult.getTotalPoints()
                        );
                        log.info(
                                "{} total points: {}",
                                beauxbatonsTaskResult.getName(),
                                beauxbatonsTaskResult.getTotalPoints()
                        );
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        try {
            allTasks.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

