package school.faang.bjs2_93141;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int DEFAULT_TIME_IN_SECOND = 1000;
    private static final int AWAIT_MINUTE = 1;

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService execute = Executors.newSingleThreadExecutor();
        return CompletableFuture.supplyAsync(() -> {
            int pointToStudent = task.getReward() / school.getTeam().size();
            log.info("{} - Школа получила {} - задачу, сложность {}",
                    school.getName(), task.getName(), task.getDifficulty());
            try {
                int sleepsMills = DEFAULT_TIME_IN_SECOND * task.getDifficulty();
                Thread.sleep(sleepsMills);
                for (Student student : school.getTeam()) {
                    student.addPoint(pointToStudent);
                }
                log.info("Студенты {} - Школы выполнили задачу! Школа получает {} очков!",
                        school.getName(), school.getTotalPoints());
                log.info("{} студента получают по {} очков!", school.getTeam().size(), pointToStudent);
            } catch (InterruptedException e) {
                log.error("Ошибка в имитаци выполнения задания");
            }
            execute.shutdown();
            if (execute.isShutdown()) {
                return school;
            }
            try {
                if (!execute.awaitTermination(AWAIT_MINUTE, TimeUnit.MINUTES)) {
                    log.info("Потоки не успели завершить все задачи за {}. Останавливаем потоки", AWAIT_MINUTE);
                    execute.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ошибка при ожидании потоков");
            }
            return school;
        }, execute);
    }
}
