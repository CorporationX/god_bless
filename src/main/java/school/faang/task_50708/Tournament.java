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

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executorService) {
        return makingSomeTasks(school, task, executorService);
    }

    public CompletableFuture<School> makingSomeTasks(School school, Task task, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            school.setStudents(school.getStudents().stream()
                    .peek(student -> {
                        int chance = RANDOM.nextInt(0, 101);
                        int baseChance = Math.max(0, 100 - task.getDifficulty() * 20);
                        if (chance <= baseChance) {
                            student.setPoints(student.getPoints() + task.getReward());
                        }
                    })
                    .toList());

            try {
                Thread.sleep(task.getDifficulty() * (long) 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return school;
        }, executorService);
    }
}
