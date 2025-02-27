package school.faang.BJS2_62826;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("⏳ {} выполняет задание: {}", school.getName(), task.getName());
                Thread.sleep(1000 * task.getDifficulty());
                school.changePointToStudents(task.getReward());
                log.info("✅ {} завершил задание: {}", school.getName(), task.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задание не выполнен", e);
            }

            return school;
        });

    }
}
