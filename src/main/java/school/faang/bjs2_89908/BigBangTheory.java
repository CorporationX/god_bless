package school.faang.bjs2_89908;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREAD_AMOUNT = 4;
    private static final int WAITING_TIME = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        List<Task> tasks = List.of(
                new Task("Эта задача", "Доделать эту задачу."),
                new Task("Правка предыдущих задач", "Исправить задачи, не прошедшие Review"),
                new Task("Новые задачи", "Решить еще 2 задачи"),
                new Task("StandUp", "Созвониться с командой и тим-лидом.")
        );
        for (Task task : tasks) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.error("Поток main устал ждать, какая-то задача заснула навечно )");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток main не смог дождаться, его прервали.");
        }
    }
}
