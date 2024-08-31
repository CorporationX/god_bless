package faang.school.godbless.sprint4.wizard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Tournament {
    private final ThreadLocalRandom generator = ThreadLocalRandom.current();

    public CompletableFuture<School> startTask(Task task, School school) {

        return CompletableFuture.supplyAsync(() -> {
            int idx = generator.nextInt(1, 4);
            try {
                Thread.sleep(idx * 1000L);
            } catch(InterruptedException e) {
                throw new RuntimeException("Thread interrupted!");
            }
            school.modifyPoints(task);
            return school;
        });
    }
}
