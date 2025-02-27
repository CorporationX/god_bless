package school.faang.task_62436;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int DEFAULT_EXP = 0;
    private static final int MILLISECONDS_PER_SECOND = 1_000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Команда школы \"{}\" приступила к выполнению задания", school.getName());
            try {
                int leadTime = task.getDifficulty() * MILLISECONDS_PER_SECOND;
                Thread.sleep(leadTime);
                return task.getReward();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток был прерван", e);
            }
        })
                .exceptionally(ex -> {
                    log.error("Произошла ошибка во время выполнения задания \"{}\"", task.getName());
                    return DEFAULT_EXP;
                })
                .thenApply(reward -> {
                    school.getTeam().forEach(student -> student.setPoints(student.getPoints() + reward));
                    return school;
                });
    }
}
