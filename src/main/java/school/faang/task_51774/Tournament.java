package school.faang.task_51774;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tournament {

    private static final Logger logger = LoggerFactory.getLogger(Tournament.class);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("Total points before task for {}: {}", school.name(), school.getTotalPoints());
                logger.info("Task {} started...", task.name());
                Thread.sleep(task.difficulty() * 1000);
                school.team().stream()
                        .forEach(s -> s.setPoints(s.getPoints() + task.reward()));
                logger.info("Total points after task for {}: {}", school.name(), school.getTotalPoints());
                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Task execution interrupted for {}", school.name(), e);
                throw new RuntimeException("Task execution interrupted for " + school.name(), e);
            }
        });
    }
}
