package school.faang.triwizard_tournament.BJS2_62446;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final Logger log = LoggerFactory.getLogger(Tournament.class);

    private static final int TASK_PROCESSING_TIME = 2000;

    public CompletableFuture<School> startTask(@NonNull School school, @NonNull Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() + TASK_PROCESSING_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Операция прервана {}", e.getMessage());
            }

            school.getTeam().forEach(student -> {
                student.setPoints(student.getPoints() + task.reward());
            });

            return school;
        });
    }
}
