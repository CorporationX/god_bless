package school.faang.bjs2_72251.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Army {
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
            return 0;
        }
    }

    public void dispose() {
        executorService.shutdownNow();
        log.info("Executor service disposed");
    }
}