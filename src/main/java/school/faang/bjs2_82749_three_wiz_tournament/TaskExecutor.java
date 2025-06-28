package school.faang.bjs2_82749_three_wiz_tournament;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
@RequiredArgsConstructor
public class TaskExecutor implements Supplier<School> {
    private final School school;
    private final Task task;

    @Override
    public School get() {
        try {
            TimeUnit.SECONDS.sleep(task.getDifficulty());
        } catch (InterruptedException e) {
            log.error("Task execution failed: {}, {}", task.getName(), e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Task {} successfully completed by team {}.", task.getName(), school.getName());
        school.getTeam()
                .forEach(s -> s.addPoints(task.getReward()));
        return school;
    }
}
