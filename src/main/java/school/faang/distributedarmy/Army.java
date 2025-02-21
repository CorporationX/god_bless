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
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(squads.size());
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
            log.info(e.getMessage());
        } catch (ExecutionException e) {
            log.info(e.getMessage());
        } finally {
            executor.shutdown();
        }

        return totalPower;
    }
}
