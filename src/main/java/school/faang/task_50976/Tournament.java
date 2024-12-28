package school.faang.task_50976;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public static final Logger LOGGER = LoggerFactory.getLogger(Tournament.class);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                LOGGER.debug("Ошибка ожидания потока, {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
    }
}
