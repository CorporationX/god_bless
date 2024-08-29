package tournament;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final ExecutorService executor;

    public Tournament(int schoolsCount) {
        executor = Executors.newFixedThreadPool(schoolsCount);
    }

    public CompletableFuture<School> startTask(@NonNull School school, @NonNull Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.startTaskForAllStudents(task);
            return school;
        }, executor);
    }

    public void finishTournament() {
        log.info("The magical tournament is ended!");
        executor.shutdown();
    }
}
