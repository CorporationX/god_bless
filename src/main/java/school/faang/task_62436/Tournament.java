package school.faang.task_62436;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int DEFAULT_EXP = 0;
    private static final int MILLISECONDS_PER_SECOND = 1_000;
    private static final String START_TASK_MESSAGE = "Команда школы \"{}\" приступила к выполнению задания";
    private static final String INTERRUPT_TASK_MESSAGE
            = "Выполнение задания \"{}\" командой школы \"{}\" было прервано";
    private static final String ERROR_TASK_MESSAGE = "Произошла ошибка во время выполнения задания \"{}\"";

    public CompletableFuture<School> startTask(School school, Task task) {
        String schoolName = school.getName();
        String taskName = task.getName();
        return CompletableFuture.supplyAsync(() -> {
            log.info(START_TASK_MESSAGE, schoolName);
            try {
                int leadTime = task.getDifficulty() * MILLISECONDS_PER_SECOND;
                Thread.sleep(leadTime);
                return task.getReward();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(INTERRUPT_TASK_MESSAGE, taskName, schoolName);
                throw new RuntimeException("Поток был прерван", e);
            }
        })
                .exceptionally(ex -> {
                    log.error(ERROR_TASK_MESSAGE, taskName);
                    return DEFAULT_EXP;
                })
                .thenApply(reward -> {
                    school.getTeam().forEach(student -> student.setPoints(student.getPoints() + reward));
                    return school;
                });
    }
}
