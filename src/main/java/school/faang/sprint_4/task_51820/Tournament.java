package school.faang.sprint_4.task_51820;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty().getTimeToComplete());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван во время ожидания завершения задачи");
            }
            for (Student student : school.team()) {
                student.addPoints(task.rewardPoints());
            }
            return school;
        });
    }
}
