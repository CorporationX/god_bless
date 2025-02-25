package school.faang.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    private static final long DIFFICULTY_COEFFICIENT = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Задание {} выполняется", task.getName());
                Thread.sleep(task.getDifficulty() * DIFFICULTY_COEFFICIENT);
            } catch (InterruptedException e) {
                log.error("Поток прерван во время выполнения задания {}", task.getName(), e);
                throw new RuntimeException(e);
            }
            List<Student> students = school.getTeam();
            log.info("Задание {} выполнено!", task.getName());
            students.forEach(student -> {
                student.addPoints(task.getReward());
                log.info("У {} {} очков", student.getName(), student.getPoints());
            });
            return school;
        });
    }
}
