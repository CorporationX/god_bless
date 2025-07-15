package school.faang.sprint3.bjs2_81109;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@NoArgsConstructor
public class Army {
    private final List<Squad<? extends Unit>> squads = new ArrayList<>();

    public void addSquad(Squad<? extends Unit> squad) {
        squads.add(squad);
    }

    public double calculateTotalPower(ExecutorService executor) {
        try {
            List<Future<Double>> futures = new ArrayList<>();
            squads.forEach(squad -> {
                futures.add(executor.submit(squad::calculateSquadPower));
            });
            double total = 0;
            for (Future<Double> future : futures) {
                total += future.get();
            }
            return total;
        } catch (ExecutionException | InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
