package school.faang.heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Army {
    List<Fighter> fighters = new ArrayList<>();
    ExecutorService service = Executors.newFixedThreadPool(4);

    public void addUnit(Fighter fighter) {
        fighters.add(fighter);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Future<Integer>> futures = new ArrayList<>();
        int totalPower = 0;

        for (Fighter fighter : fighters) {
            futures.add(service.submit(fighter::getPower));
        }

        for (Future<Integer> future : futures) {
            try {
                totalPower += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        service.shutdown();

        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Пришла неожиданная фигня");
            service.shutdownNow();
        }

        return totalPower;
    }
}
