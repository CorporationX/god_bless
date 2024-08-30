package faang.school.godbless.multithreading.parallelism.hmm;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() {
        List<UnitThread> threads = new ArrayList<>();

        for (Unit unit : units) {
            UnitThread thread = new UnitThread(unit);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;
        for (UnitThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
