package school.faang.threewizards;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class Tournament {
    private final ExecutorService executor;

    public CompletableFuture<School> startTask(SchoolAssignment schoolAssignment) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(schoolAssignment.task().getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            schoolAssignment.school().addPoints(schoolAssignment.task().getDifficulty());
            return schoolAssignment.school();
        }, executor);
    }
}
