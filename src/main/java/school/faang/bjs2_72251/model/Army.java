package school.faang.bjs2_72251.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Army {
    private static final int MAX_TIMEOUT = 30;

    private final List<Squad> squads = new ArrayList<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        try {
            List<Future<Integer>> futures = squads.stream()
                    .map(squad -> executorService.submit(squad::calculateSquadPower))
                    .toList();
            int totalPower = 0;
            for (Future<Integer> future : futures) {
                totalPower += future.get();
            }
            return totalPower;
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception with message {} was thrown", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void dispose() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(MAX_TIMEOUT, TimeUnit.MINUTES)) {
                log.warn("Not all tasks finished at the time. Finishing thread pull...");
                executorService.shutdownNow();
            } else {
                log.info("All tasks passed");
            }
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted");
            executorService.shutdownNow();
        }
    }
}