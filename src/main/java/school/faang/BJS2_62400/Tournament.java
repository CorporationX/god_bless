package school.faang.BJS2_62400;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private final ExecutorService executor = Executors.newFixedThreadPool(6);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                log.error(ConstAndMessages.ERROR_THREAD);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            log.info(ConstAndMessages.SCHOOL_COMPLETED_TASK, school.getName(), task.getName());
            return school;
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

}
