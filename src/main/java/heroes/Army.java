package heroes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Army {
    private final List<Squad> squads = new ArrayList<>();
    private int totalPower = 0;

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    private synchronized void addPower(int power) {
        totalPower += power;
    }

    public int calculateTotalPower() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(squads.size());

        for (Squad squad : squads) {
            executorService.submit(() -> {
                try {
                    int squadPower = squad.calculateSquadPower();
                    addPower(squadPower);
                } catch (Exception e) {
                    log.error("Error calculating power for squad: {}", squad, e);
                    throw new RuntimeException("Failed to calculate squad power for squad: " + squad, e);
                }
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Waiting for threads to finish was interrupted", e);
            Thread.currentThread().interrupt();
        }

        return totalPower;
    }
}
