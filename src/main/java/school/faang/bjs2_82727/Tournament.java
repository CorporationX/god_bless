package school.faang.bjs2_82727;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Tournament {
    private final ExecutorService threadPool;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Student student = school.getStudentForTask();

                log.info("{} из {} начал испытание '{}'", student.getName(), school.getName(), task.getName());
                Thread.sleep(task.getDifficulty());

                boolean isDone = ThreadLocalRandom.current().nextBoolean();
                if (isDone) {
                    int reward = task.calculateReward();
                    student.setPoints(reward);
                    log.info("{} из {} завершил испытание '{}'. Получено {} опыта",
                             student.getName(), school.getName(), task.getName(), reward);
                } else {
                    log.info("{} из {} не справился с испытанием '{}'",
                             student.getName(), school.getName(), task.getName());
                }

                return school;

            } catch (InterruptedException e) {
                log.error("Поток прерван. Испытание не завершено");
                Thread.currentThread().interrupt();
                throw new CompletionException("Поток прерван. Испытание не завершено", e);
            }
        }, threadPool);
    }
}
