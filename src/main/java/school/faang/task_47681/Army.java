package school.faang.task_47681;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Unit> units = Collections.synchronizedList(new ArrayList<>());

    public void addUnit(Unit unit) {
        synchronized (units) {
            units.add(unit);
        }
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();

        units.parallelStream()
                .mapToInt(Unit::getPower)
                .forEach(power -> {
                    synchronized (totalPower) {
                        totalPower.addAndGet(power);
                    }
                });

        return totalPower.get();
    }

    public List<Unit> getUnits() {
        synchronized (units) {
            return new ArrayList<>(units);
        }
    }
}