package school.faang.sword_and_magic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army {
    private List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(squads.size());
        List<Future<Integer>> results = new ArrayList<>();

        for (Squad squad : squads) {
            Callable<Integer> task = squad::calculateSquadPower;
            results.add(executorService.submit(task));
        }

        int totalPower = 0;
        for (Future<Integer> result : results) {
            totalPower += result.get();
        }

        executorService.shutdown();
        return totalPower;
    }
}
