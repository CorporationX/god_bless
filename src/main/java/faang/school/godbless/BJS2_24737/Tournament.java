package faang.school.godbless.BJS2_24737;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private static final int EXECUTION_MULTIPLIER = 1000;
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * EXECUTION_MULTIPLIER);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.students().forEach(student -> student.addPoints(task.reward()));
            return school;
        }, executorService);
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
