package school.faang.bjs2_92878;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    public static ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("ученики школы {} выполняют задание \"{}\" со сложностью {}...", school.getName(),
                        task.getName(), task.getDifficult());
                TimeUnit.SECONDS.sleep(task.getDifficult().getDifficultLevelPoints());
                school.increaseSchoolPoints(task.getReward());
                log.info("ученики школы {} успешно справились с заданием!", school.getName());
                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, EXECUTOR);
    }
}
