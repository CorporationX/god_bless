package school.faang.task_50783;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) (Math.random() * 10000));
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения задачи {}", e.getMessage());
                throw new RuntimeException(e);
            }

            return school;
        }
        ).thenApply((s) -> {
            if (school.getTeam().isEmpty()) {
                throw new IllegalArgumentException("Команда школы пуста");
            }

            float giveReward = task.reward() / school.getTeam().size();
            school.getTeam().forEach(student -> {
                student.setPoints(student.getPoints() + giveReward);
            });

            return s;
        });
    }
}
