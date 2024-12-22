package school.faang.army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(units.size());
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (Unit unit : units) {
            tasks.add(() -> unit.getPower());
        }
        int totalPower = 0;
        try {
            List<Future<Integer>> results = executor.invokeAll(tasks);
            for (Future<Integer> result : results) {
                totalPower += result.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        return totalPower;
    }
}
