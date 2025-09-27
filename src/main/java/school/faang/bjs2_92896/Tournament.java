package school.faang.bjs2_92896;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long TASK_DURATION = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Начинается задание {} для школы {}", task.name(), school.name());
        return CompletableFuture.supplyAsync(() -> {
            int pointsBefore = school.getTotalPoints();

            try {
                log.info("Школа {} выполняет задание '{}' (сложность: {} сек)",
                        school.name(), task.name(), task.difficulty());
                Thread.sleep(task.difficulty() * TASK_DURATION);
                log.info("Школа '{}' завершила задание! Начисляем {} очков каждому студенту",
                        school.name(), task.reward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задание '{}' прервано для школы {}",
                        task.name(), school.name(), e);
                throw new RuntimeException(e);
            }

            for (Student student : school.students()) {
                student.addPoints(task.reward());
            }

            int schoolPointsAfter = school.getTotalPoints();
            log.info("ИТОГО для школы {}: было {} → стало {} (получено +{})",
                    school.name(), pointsBefore, schoolPointsAfter,
                    schoolPointsAfter - pointsBefore);

            return school;
        });
    }
}
