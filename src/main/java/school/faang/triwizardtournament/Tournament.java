package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int TASK_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} начинает выполнять задание - {}", school.name(), task.name());
                Thread.sleep((long) TASK_TIME * task.difficulty());
                awardPoints(school, task);
                log.info("{} выполнила свое задание", school.name());
                return school;
            } catch (InterruptedException e) {
                log.error("Поток прерван {}", e.getMessage(), e);
                throw new RuntimeException("Ошибка при обработке задачи - " + task.name(), e);
            }
        });
    }

    private void awardPoints(School school, Task task) {
        List<Student> students = school.team();
        double reward = task.reward() / students.size();
        students.forEach(student -> student.addPoints(reward));
    }
}
