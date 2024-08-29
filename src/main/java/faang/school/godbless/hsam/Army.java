package faang.school.godbless.hsam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Army {
    private static List<Unit> units = new ArrayList<>();

    public static void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculatePower() throws ExecutionException, InterruptedException {
        Map<Class<? extends Unit>, List<Unit>> mapUnits = new HashMap<>();
        for (Unit unit : units) {
            mapUnits.computeIfAbsent(unit.getClass(), k -> new ArrayList<>()).add(unit);
        }

        ExecutorService poolThreads = Executors.newFixedThreadPool(mapUnits.size());
        List<Future<Integer>> futures = new ArrayList<>();

        for (List<Unit> unitList : mapUnits.values()) {
            PowerThread powerThread = new PowerThread(unitList);
            futures.add(poolThreads.submit(powerThread));
        }

        poolThreads.shutdown();
        int totalPower = 0;
        for (Future<Integer> future : futures) {
            totalPower += future.get();
        }
        return totalPower;
    }
}
