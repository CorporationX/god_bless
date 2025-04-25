package school.faang.bjs2_72252;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Army {

    private List<Squad> squads;
    private ExecutorService executor;

    public Army(List<Squad> squads) {
        this.squads = squads;
        executor = Executors.newFixedThreadPool(squads.size());
    }

    public int calculateArmyPower(List<Squad> squads) throws InterruptedException {
        try {
            return squads.stream().map(executor::submit)
                    .map(x -> {
                        try {
                            return x.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }).reduce(0, Integer::sum);
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
    }
}
