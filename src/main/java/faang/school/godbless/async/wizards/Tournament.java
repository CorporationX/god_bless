package faang.school.godbless.async.wizards;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Tournament {
    private static final int TASK_COEFF = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("[Thread: %s]: %s started task %s\n",
                        Thread.currentThread().getName(), school.getName(), task.getName());

                // Имитация выполнения задания
                int rndValue = ThreadLocalRandom.current().nextInt(TASK_COEFF + 1);
                Thread.sleep(task.getDifficulty() * 1000L + rndValue);

                // Начисляем очки студентам
                int rewardPoints = (int) Math.round((double) task.getReward() * (1 - (double) rndValue / TASK_COEFF));
                school.getStudents().forEach(student -> student.addPointsThreadSafe(rewardPoints));
                System.out.printf("[Thread: %s]: %s every student got %d reward points\n",
                        Thread.currentThread().getName(), school.getName(), rewardPoints);

                System.out.printf("[Thread: %s]: %s finished task %s\n",
                        Thread.currentThread().getName(), school.getName(), task.getName());
                return school;
            } catch (InterruptedException e) {
                throw new RuntimeException("Task was interrupted");
            }
        });
    }
}
