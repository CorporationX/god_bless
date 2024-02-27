package faang.school.godbless.army_of_heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();

        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {

            Thread thread = new Thread(() -> totalPower.addAndGet(unit.getPower()));
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
