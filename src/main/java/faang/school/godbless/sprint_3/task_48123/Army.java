package faang.school.godbless.sprint_3.task_48123;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    public final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (unit.getPower() < 1) {
            throw new IllegalArgumentException("Unit cannot have power less than 1");
        }
        units.add(unit);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {
            Thread thread = new Thread(() -> totalPower.set(totalPower.get() + unit.getPower()));
            thread.start();
            threads.add(thread);
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("An exception occurred!" + e);
        }

        return totalPower.get();
    }
}
