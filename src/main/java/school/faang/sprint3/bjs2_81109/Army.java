package school.faang.sprint3.bjs2_81109;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@AllArgsConstructor
public class Army {
    private List<Squad> squads = new ArrayList<>();

    public Army() {
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public double calculateTotalPower() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            List<Future<Double>> futures = new ArrayList<>();
            squads.forEach(squad -> {
                futures.add(executor.submit(squad::calculateSquadPower));
            });
            double total = 0;
            for (Future<Double> future : futures) {
                total += future.get();
            }
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
            return total;
        } catch (ExecutionException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0.0;
        }
    }
}
