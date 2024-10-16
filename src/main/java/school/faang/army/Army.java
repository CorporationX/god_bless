package school.faang.army;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Army {

    public final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<PowerCalculator> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {
            PowerCalculator task = new PowerCalculator(unit);
            tasks.add(task);
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        return tasks.stream().mapToInt(PowerCalculator::getResult).sum();
    }

    public void addUnit(Unit unit) {
        Objects.requireNonNull(unit, "Unit cannot be null");
        units.add(unit);
    }
}
