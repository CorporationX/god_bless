package school.faang.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int TIMEOUT_ONE_SECOND = 1_000;
    private static final Random RANDOM = new Random();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) TIMEOUT_ONE_SECOND * task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage(), e);

            }
            //предпологаем, что в конкурсе участвует один студент от команды, которого выбират случайно
            int teamSize = school.getTeam().size();
            int studentInTeam = RANDOM.nextInt(0, teamSize);
            Student student = school.getTeam().get(studentInTeam);
            student.addPoints(task.getReward());
            return school;
        });

    }
}
