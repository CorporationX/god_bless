package school.faang.task_61192;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futures = new ArrayList<>();
        for (Squad squad : squads) {
            Future<Integer> future = executor.submit(squad::calculateSquadPower);
            futures.add(future);
        }
        int total = 0;
        for (Future<Integer> future : futures) {
            total += future.get();
        }
        return total;
    }
}


