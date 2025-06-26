package school.faang.module4.hogwarts;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long SLEEP_TIME_IN_MS = 1_000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("\"%s\" start \"%s\" task\n", school.getName(), task.getName());
            try {
                Thread.sleep(SLEEP_TIME_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.receivePoints(task.getRewards());
            System.out.printf("\"%s\" ended \"%s\" task\n", school.getName(), task.getName());
            return school;
        });
    }

}
