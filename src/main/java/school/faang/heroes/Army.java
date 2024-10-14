package school.faang.heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Army {
    List<Fighter> fighters = new ArrayList<>();
    ExecutorService service = Executors.newFixedThreadPool(4);
    int totalPower = 0;

    public void addUnit(Fighter fighter) {
        fighters.add(fighter);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Callable<Integer>> tasks = fighters.stream()
                .map(f -> (Callable<Integer>) f::getPower)
                .toList();

        List<Future<Integer>> futures = service.invokeAll(tasks);

        for (Future<Integer> future : futures) {
            try {
                totalPower += future.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        service.shutdown();

        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Беда подкралась!");
            service.shutdownNow();
        }

        return totalPower;
    }
}


