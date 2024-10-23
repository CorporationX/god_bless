package school.faang.fourthStream.BJS2_39021;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.info("Упс.. Выполнеие задания {} было прервано\n Причина:\n{}", task.getName(), e.getMessage());
            }

            school.getTeam().forEach(student -> student.addPoints(task.getReward()));

            return school;
        });
    }
}