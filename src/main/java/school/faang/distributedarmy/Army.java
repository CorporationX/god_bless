package school.faang.distributedarmy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Army {
    private static final int THREAD_POOL_SIZE = 3;
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Callable<Integer>> tasks = new ArrayList<>();

        for (Squad squad : squads) {
            tasks.add(squad::calculateSquadPower);
        }

        int totalPower = 0;

        try {
            List<Future<Integer>> result = executor.invokeAll(tasks);
            for (Future<Integer> task : result) {
                totalPower += task.get();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Task execution was interrupted. Message: {}", e.getMessage(), e);
            throw new RuntimeException("Task execution was interrupted", e);
        } catch (ExecutionException e) {
            log.error("Execution failed while calculating total power. Message: {}", e.getMessage(), e);
            throw new RuntimeException("Execution failed while calculating total power", e);
        } finally {
            executor.shutdown();
        }

        return totalPower;
    }
}
