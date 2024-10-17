package school.faang.DistributedArmy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Army {

    private final List<Unit> units;
    private final ExecutorService service;

    public Army() {
        this.units = new ArrayList<>();
        service = Executors.newFixedThreadPool(5);
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Callable<Integer>> tasks = units.stream().map(e -> (Callable<Integer>) e::getPower).toList();

        List<Future<Integer>> futures = service.invokeAll(tasks);


        int totalPower = 0;
        for (Future<Integer> future : futures) {
            try {
                totalPower+=future.get();
            } catch (ExecutionException e) {
                throw new InterruptedException("Something went wrong");
            }
        }

        service.shutdown();

        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Something went wrong");
            service.shutdownNow();
        }

        return totalPower;
    }
}
