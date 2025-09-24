package school.faang.bjs2_93141;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MagicalTournament {
    private static final int YEARS_HOGWARTS_STUDENT = 5;
    private static final int YEARS_BEAUXBATONS_STUDENT = 6;
    private static final int DEFAULT_POINTS_STUDENT = 6;
    private static final int DEFAULT_DIFFICULTY = 10;
    private static final int START_SEEDS = 1;
    private static final int DEFAULT_REWARD = 250;
    private static final int THREAD_COUNT = 3;
    private static final int AWAIT_MINUTE = 1;
    private static final ExecutorService execute = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        Random random = new Random();
        List<Student> hogwartsTeam = List.of(
                new Student("Harry", YEARS_HOGWARTS_STUDENT, DEFAULT_POINTS_STUDENT),
                new Student("Hermione", YEARS_HOGWARTS_STUDENT, DEFAULT_POINTS_STUDENT)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", YEARS_BEAUXBATONS_STUDENT, DEFAULT_POINTS_STUDENT),
                new Student("Gabrielle", YEARS_BEAUXBATONS_STUDENT, DEFAULT_POINTS_STUDENT)
        );
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        Task task1 = new Task(
                "Triwizard Tournament",
                random.nextInt(START_SEEDS, DEFAULT_DIFFICULTY),
                random.nextInt(START_SEEDS, DEFAULT_REWARD)
        );
        Task task2 = new Task(
                "Yule Ball Preparations",
                random.nextInt(START_SEEDS, DEFAULT_DIFFICULTY),
                random.nextInt(START_SEEDS, DEFAULT_REWARD)
        );
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, execute);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, execute);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        log.info("{} - Школа победила в соревновании трех волшебников!", hogwarts.getName());
                    } else {
                        log.info("{} - Школа победила в соревновании трех волшебников!", beauxbatons.getName());
                    }
                });
        shutdown();
    }

    private static void shutdown() {
        execute.shutdown();
        try {
            if (!execute.awaitTermination(AWAIT_MINUTE, TimeUnit.MINUTES)) {
                log.info("Потоки не успели завершить все задачи за {}. Останавливаем потоки", AWAIT_MINUTE);
                execute.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка при ожидании потоков");
        }
    }
}
