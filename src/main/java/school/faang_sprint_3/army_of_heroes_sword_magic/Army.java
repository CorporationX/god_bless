package school.faang_sprint_3.army_of_heroes_sword_magic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotal() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> calculations = new ArrayList<>();

        units.forEach(unit -> {
            PowerCalculator calculation = new PowerCalculator(unit);
            calculations.add(calculation);
            Thread thread = new Thread(calculation);
            threads.add(thread);
            thread.start();
        });

        for (Thread thread : threads) {
            thread.join();
        }

        calculations.forEach(calculation -> totalPower.addAndGet(calculation.getPower()));

        return totalPower.get();
    }
}
