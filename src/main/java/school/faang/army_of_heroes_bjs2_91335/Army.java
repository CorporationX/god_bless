package school.faang.army_of_heroes_bjs2_91335;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@AllArgsConstructor
public class Army {
    private final List<Squad> squads = new ArrayList<>();
    ExecutorService executor;

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public Army() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public int calculateTotalPower() throws ExecutionException, InterruptedException {
        List<Future<Integer>> results = new ArrayList<>();

        for (Squad squad : squads) {
            results.add(executor.submit(new SquadPowerCalculator(squad)));
        }

        int totalPower = 0;

        for (Future<Integer> result : results) {
            totalPower += result.get();
        }
        executor.shutdown();
        return totalPower;
    }


}
