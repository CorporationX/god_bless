package bjs2_92887;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long MILLIS_IN_SECOND = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s начинает задание: %s%n", school.getName(), task.getName());
                Thread.sleep(task.getDifficulty() * MILLIS_IN_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            school.getTeam().forEach(student -> student.addPoints(task.getReward()));

            System.out.printf("%s завершила задание: %s (наградa %d)%n",
                    school.getName(), task.getName(), task.getReward());

            return school;
        });
    }
}
