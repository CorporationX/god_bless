package school.faang.task_50708;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Data
@AllArgsConstructor
public class Tournament {
    private static final Random RANDOM = new Random();
    private final int easyTime = 2999;
    private final int hardTime = 6999;

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executorService) {
        int baseChanceEasyLevel = RANDOM.nextInt(50, 101);
        int baseChanceHardLevel = 20;

        return switch (task.getDifficulty()) {
          case 0, 1, 2 -> makingSomeTasks(school, task, baseChanceEasyLevel, easyTime)
                    .thenApplyAsync(s -> s, executorService);
          case 3, 4, 5 -> makingSomeTasks(school, task, baseChanceHardLevel, hardTime)
                    .thenApplyAsync(s -> s, executorService);
          default -> throw new IllegalArgumentException("Something went wrong!");
        };
    }

    public CompletableFuture<School> makingSomeTasks(School school, Task task, int baseChance, int time) {
        return CompletableFuture.supplyAsync(() -> {
            int chance = RANDOM.nextInt(0, 101);
            school.setStudents(school.getStudents().stream()
                    .peek(student -> {
                        if (chance <= baseChance) {
                            student.setPoints(student.getPoints() + task.getReward());
                        }
                    })
                    .toList());

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return school;
        });
    }
}
