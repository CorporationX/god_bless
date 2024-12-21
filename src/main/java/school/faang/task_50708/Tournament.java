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
    private static final int EASY_TIME = 2999;
    private static final int HARD_TIME = 6999;

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executorService) {
        int baseChanceEasyLevel = RANDOM.nextInt(50, 101);
        int baseChanceHardLevel = 20;

        return switch (task.getDifficulty()) {
          case 0, 1, 2 -> CompletableFuture.supplyAsync(() -> {
                int chance = RANDOM.nextInt(0, 101);
                school.setStudents(school.getStudents().stream()
                        .peek((student -> {
                            if (chance <= baseChanceEasyLevel) {
                                student.setPoints(student.getPoints() + task.getReward());
                            }
                        }))
                        .toList());

                try {
                    Thread.sleep(EASY_TIME);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return school;
            }, executorService);
          case 3, 4, 5 -> CompletableFuture.supplyAsync(() -> {
                int chance = RANDOM.nextInt(0, 101);
                school.setStudents(school.getStudents().stream()
                        .peek((student -> {
                            if (chance <= baseChanceHardLevel) {
                                student.setPoints(student.getPoints() + task.getReward());
                            }
                        }))
                        .toList());

                try {
                    Thread.sleep(HARD_TIME);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return school;
            }, executorService);
          default -> throw new IllegalArgumentException("Something went wrong!");
        };
    }
}
