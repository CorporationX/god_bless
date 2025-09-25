package school.faang.bjs2_92849;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int HARRY_YEAR = 5;
    private static final int HARRY_POINTS = 0;
    private static final int HERMIONE_YEAR = 5;
    private static final int HERMIONE_POINTS = 0;
    private static final int FLEUR_YEAR = 6;
    private static final int FLEUR_POINTS = 0;
    private static final int GABRIELLE_YEAR = 6;
    private static final int GABRIELLE_POINTS = 0;
    private static final int TASK_ONE_DIFFICULTY = 10;
    private static final int TASK_ONE_REWARD = 100;
    private static final int TASK_TWO_DIFFICULTY = 5;
    private static final int TASK_TWO_REWARD = 50;
    private static final int COUNT_THREADS = 4;
    private static final int AWAIT_TERMINATE_MIN = 1;
    private static final ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", HARRY_YEAR, new AtomicInteger(HARRY_POINTS)),
                new Student("Hermione", HERMIONE_YEAR, new AtomicInteger(HERMIONE_POINTS))
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", FLEUR_YEAR, new AtomicInteger(FLEUR_POINTS)),
                new Student("Gabrielle", GABRIELLE_YEAR, new AtomicInteger(GABRIELLE_POINTS))
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", TASK_ONE_DIFFICULTY, TASK_ONE_REWARD);
        Task task2 = new Task("Yule Ball Preparations", TASK_TWO_DIFFICULTY, TASK_TWO_REWARD);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, executor);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, executor);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        CompletableFuture<Void> result = allTasks.thenApplyAsync(v -> {
            School hogwartsResult = hogwartsTask.join();
            School beauxbatonsResult = beauxbatonsTask.join();

            int hogwartsPoints = hogwartsResult.getTotalPoints();
            int beauxbatonsPoints = beauxbatonsResult.getTotalPoints();

            log.info("{}: {} очков", hogwartsResult.getName(), hogwartsPoints);
            log.info("{}: {} очков", beauxbatonsResult.getName(), beauxbatonsPoints);

            if (hogwartsPoints > beauxbatonsPoints) {
                return hogwartsResult.getName() + " победили в турнире!";
            } else if (beauxbatonsPoints > hogwartsPoints) {
                return beauxbatonsResult.getName() + " победили в турнире!";
            } else {
                return "Ничья! Обе школы показали одинаковый результат!";
            }
        }, executor).thenAcceptAsync(winnerMessage -> {
            log.info(winnerMessage);
        }, executor).exceptionally(throwable -> {
            log.error("Ошибка во время турнира: {}", throwable.getMessage());
            return null;
        });

        result.join();

        shutdown();
    }

    private static void shutdown() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATE_MIN, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
