package school.faang_sprint_3.three_wizards_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            timeForTask(task);
            synchronized (school) {
                school.students().forEach(student -> student.addPoints(task.reward() / school.students().size()));
            }
            return school;
        }, threadPool);
    }

    private void timeForTask(Task task) {
        log.info("{} started", task.name());
        try {
            if (task.difficulty() > 5) {
                Thread.sleep(10000);
            } else {
                Thread.sleep(5000);
            }
            log.info("{} finished", task.name());
        } catch (InterruptedException e) {
            log.error("An error occurred while waiting for task to finish", e);
            throw new IllegalStateException(e);
        }
        threadPool.shutdown();
    }
}
