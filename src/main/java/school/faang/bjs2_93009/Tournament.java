package school.faang.bjs2_93009;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Tournament {
    private static final int THREAD_AMOUNT = 2;
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_AMOUNT);

    static CompletableFuture<School> startTask(School school, Task task) {
        synchronized (school.getLock()) {
            return CompletableFuture.supplyAsync(() -> {
                log.info("{} начала выполнять задание по предмету {}.", school.getName(), task.getName());
                try {
                    TimeUnit.SECONDS.sleep(task.getDifficulty());
                    for (Student student : school.getTeam()) {
                        student.setPoints(student.getPoints() + task.getReward());
                    }
                    school.getTotalPoints();
                    log.info("{} закончила выполнять задание по предмету {}", school.getName(), task.getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("{} прекратила выполнять задание по предмету {}, она сдалась",
                            school.getName(), task.getName());
                }
                return school;
            }, EXECUTOR);
        }
    }
}
