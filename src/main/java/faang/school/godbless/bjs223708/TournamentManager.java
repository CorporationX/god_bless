package faang.school.godbless.bjs223708;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class TournamentManager {
    private List<Knight> knights;

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        knights
                .stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(executor::execute);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}