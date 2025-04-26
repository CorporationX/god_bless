package school.faang.bjs2_72252;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Army {

    private List<Squad> squads;
    private ExecutorService executor;

    public Army(List<Squad> squads) {
        this.squads = squads;
        this.executor = Executors.newFixedThreadPool(5);
    }


    public int calculateArmyPower() throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = new ArrayList<>();
        int result = 0;
        try {
            for (Squad squad : squads) {
                futures.add(executor.submit(squad));
            }
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
        for (Future<Integer> future : futures) {
            result += future.get();
        }
        return result;
    }
}
