package faang.school.godbless.async.triwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Tournament {
    private static final long MIN_TIMEOUT = 3000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            var randomTimeout = ThreadLocalRandom.current().nextLong(1000);

            try {
                Thread.sleep(MIN_TIMEOUT + randomTimeout * task.difficulty());
            } catch (InterruptedException e) {
                log.error("Task (" + task.name() + ") execution was interrupted.", e);
            }

            return school.updatePoints(task.reward());
        });
    }
}
