package school.faang.moduleone.sprintfour.task_43582;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Ошибка при выполнении задачи: " + e.getMessage());
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
    }
}
