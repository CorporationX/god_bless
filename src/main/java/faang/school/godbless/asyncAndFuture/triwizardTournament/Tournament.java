package faang.school.godbless.asyncAndFuture.triwizardTournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private final int NUMBER_THREADS = 5;
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("Школа %s начала выполнять задание: %s\n", school.getName(), task.getName());

            //имитация выполнения
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            System.out.printf("Школа %s закончила выполнять задание: %s\n", school.getName(), task.getName());

            return school;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
