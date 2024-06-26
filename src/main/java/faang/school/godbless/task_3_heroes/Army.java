package faang.school.godbless.task_3_heroes;

import faang.school.godbless.task_3_heroes.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<UnitThread> threads = new ArrayList<>();

        for (int i = 0; i < units.size(); i++) {
            UnitThread thread = new UnitThread("thread_"+i, units.get(i));
            threads.add(thread);
            thread.start();
        }

        for (UnitThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return sumPower(threads);
    }

    private static int sumPower(List<UnitThread> threads) {
        int totalPower = 0;
        for (UnitThread t : threads) {
           totalPower += t.getUnitPower();
        }
        return totalPower;
    }

}
