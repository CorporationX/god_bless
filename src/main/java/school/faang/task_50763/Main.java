package school.faang.task_50763;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = ExecutorServiceFactory.createExecutorService();
        Tournament tournament = new Tournament(executorService);

        School hogwarts = TournamentFactory.createHogwarts();
        School beauxbatons = TournamentFactory.createBeauxbatons();
        var tasks = TournamentFactory.createTasks();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, tasks.get(0));
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, tasks.get(1));

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            if (hogwartsPoints > beauxbatonsPoints) {
                log.info("The winner is {} with {} points!", hogwarts.getName(), hogwartsPoints);
            } else if (hogwartsPoints < beauxbatonsPoints) {
                log.info("The winner is {} with {} points!", beauxbatons.getName(), beauxbatonsPoints);
            } else {
                log.info("It's a draw between {} and {} with {} points each!",
                        hogwarts.getName(), beauxbatons.getName(), hogwartsPoints);
            }
        }).join();

        executorService.shutdown();
        if (!executorService.isShutdown()) {
            log.info("ExecutorService is shutting down gracefully.");
        }
    }
}