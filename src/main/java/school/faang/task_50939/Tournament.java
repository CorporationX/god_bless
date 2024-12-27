package school.faang.task_50939;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
public class Tournament {
    private final ExecutorService executorService;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("School {} started working on a task {}", school.name(), task.name());
            long leadTime = task.difficulty() * 1000L;

            try {
                Thread.sleep(leadTime);
            } catch (InterruptedException e) {
                log.error("Error occurred: {}", e.getMessage());
                throw new RuntimeException(e);
            }

            school.studentList().forEach(s ->
                    s.addPoints(task.reward()));

            log.info("School {} finished working on a task {}", school.name(), task.name());
            return school;
        });
    }

    public void finishTournament(long time) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(time, TimeUnit.SECONDS)) {
                log.info("Not all schools have completed their assignments.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error occurred: {}", e.getMessage());
            executorService.shutdownNow();
        }
    }
}
