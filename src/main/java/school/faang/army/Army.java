package school.faang.army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ExecutionException;

public class Army {
    private List<Unit> units = new ArrayList<>();
    private int DEFAULT_POOL_SIZE = 3;

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public int calculateTotalPower() {
        ForkJoinPool customThreadPool = new ForkJoinPool(DEFAULT_POOL_SIZE);
        try {
            return customThreadPool.submit(() -> units.parallelStream()
                    .peek(unit -> System.out.println(Thread.currentThread().getName() + " - power: " + unit.getPower()))
                    .mapToInt(Unit::getPower).sum()).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0;
        } finally {
            customThreadPool.shutdown();
        }
    }
}
