package school.faang.task_51774;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

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
            try {
                School hogwartsResult = hogwartsTask.get();
                School beauxbatonsResult = beauxbatonsTask.get();

                School winner = hogwartsResult.getTotalPoints() > beauxbatonsResult.getTotalPoints()
                        ? hogwartsResult
                        : beauxbatonsResult;

                logger.info("The winner is: {} with total points: {}", winner.name(), winner.getTotalPoints());
            } catch (Exception e) {
                logger.error("Error while determining the winner: {}", e.getMessage(), e);
            }
        }).join();
    }
}
