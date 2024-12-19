package school.faang.task_47815;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final Logger log = LoggerFactory.getLogger(Army.class);
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int threadsCount = units.size();
        UnitThread[] threads = new UnitThread[threadsCount];

        for (var i = 0; i < threadsCount; i++) {
            Unit unit = units.get(i);
            threads[i] = new UnitThread(unit);
            threads[i].start();
        }

        int totalPower = 0;
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.warn("Thread was interrupted", e);
            }
            totalPower += thread.getPower();
        }

        return totalPower;
    }
}
