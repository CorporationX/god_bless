package school.faang.module1.bjs2_82756;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Tournament {

    private final ExecutorService executorService;
    private static final long SLEEP_MULTIPLIER_MS = 100L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} начинает выполнение задания {}", school.getName(), task.getName());
            try {
                Thread.sleep(task.getDifficulty() * SLEEP_MULTIPLIER_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван. испытание не завершено");
                throw new RuntimeException(e);
            }
            int rewardPerStudent = task.calculateRewardPerStudent(school);
            school.getStudents().forEach(student -> student.addPoints(rewardPerStudent));
            log.info("Школа '{}' завершила задание '{}'. Текущие очки: {}",
                    school.getName(), task.getName(), school.getTotalPoints());
            return school;
        }, executorService);
    }
}