package faang.school.godbless.dolbahlop.multithreading.parallelism;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private List<Unit> units;
    private Map<String, List<Unit>> unitsByType = new HashMap<>();

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() {
        devideUnitsByType(units);

        ThreadsCalculator[] threads = new ThreadsCalculator[unitsByType.size()];
        Thread[] threadInstances = new Thread[unitsByType.size()];

        int index = 0;
        for (Map.Entry<String, List<Unit>> entry : unitsByType.entrySet()) {
            List<Unit> unitList = entry.getValue();
            ThreadsCalculator calculator = new ThreadsCalculator(0, unitList);
            threads[index] = calculator;
            threadInstances[index] = new Thread(calculator);
            threadInstances[index].start();
            index++;
        }

        for (Thread thread : threadInstances) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int totalPower = 0;
        for (ThreadsCalculator calculator : threads) {
            totalPower += calculator.getUnitsTotalPower();
        }

        return totalPower;
    }

    private void devideUnitsByType(List<Unit> units) {
        for (Unit unit : units) {
            unitsByType.computeIfAbsent(unit.getClass().getSimpleName(), type -> new ArrayList<>()).add(unit);
        }
    }
}
