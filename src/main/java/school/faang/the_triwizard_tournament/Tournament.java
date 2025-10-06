package school.faang.the_triwizard_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * Проект: god_bless
 * Класс Tournament
 * Автор: Vital
 */

@Slf4j
public class Tournament {
    private static final int TIME_UNIT_MS = 500;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} начинает задание '{}'", school.getName(), task.getName());
                Thread.sleep((long) task.getDifficulty() * TIME_UNIT_MS);
                school.getTeam().forEach(student -> student.addPoints(task.getReward()));
                log.info("{} завершила задание '{}', каждому студенту добавлено {} очков",
                        school.getName(), task.getName(), task.getReward());
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения задания '{}' для школы {}", task.getName(), school.getName(), e);
                Thread.currentThread().interrupt();
            }
            return school;
        });
    }
}