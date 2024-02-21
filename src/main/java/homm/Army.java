package homm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int totalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {
            Thread thread = new Thread(() -> {
                int unitPower = unit.getPower();
                totalPower.addAndGet(unitPower);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalPower.get();
    }
}
