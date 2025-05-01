package school.faang.threemagicians;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Tournament {
    private static final int TIME_RUN_EASY_TASK_SECOND = 0;
    private static final int TIME_RUN_NORMAL_TASK_SECOND = 5;
    private static final int TIME_RUN_HARD_TASK_SECOND = 7;
    private static final int TIME_DEFAULT_SECOND = 1;
    private static final int THREAD_COUNT = 2;
    private final Object lock = new Object();
    private final ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Школа {} выполняет задачу {}", school.getName(), task.name());
            try {
                log.info("имитация выполнения");
                switch (task.difficulty()) {
                    case EASY -> TimeUnit.SECONDS.sleep(TIME_RUN_EASY_TASK_SECOND);
                    case NORMAL -> TimeUnit.SECONDS.sleep(TIME_RUN_NORMAL_TASK_SECOND);
                    case HARD -> TimeUnit.SECONDS.sleep(TIME_RUN_HARD_TASK_SECOND);
                    default -> TimeUnit.SECONDS.sleep(TIME_DEFAULT_SECOND);
                }
            } catch (InterruptedException e) {
                log.info("Поток прерван");
                Thread.currentThread().interrupt();
            }
            synchronized (lock) {
                log.info("Добавление очков студентам школы {}", school.getName());
                school.getTeam().forEach(student -> student.addPoint(task.reward()));
            }
            return school;
        }, pool);
    }

    public void terminatedPool() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Поток прерван");
            Thread.currentThread().interrupt();
        }
    }
}