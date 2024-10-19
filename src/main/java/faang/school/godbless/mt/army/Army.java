package faang.school.godbless.mt.army;

import faang.school.godbless.mt.army.units.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Army {
    private final List<Unit> army;

    public Army(List<Unit> army) {
        this.army = new ArrayList<>(army);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();

        for (var unit : army) {
            Thread thread = new Thread(() -> totalPower.addAndGet(unit.getPower()));
            threads.add(thread);
            thread.start();
        }

        for(var thread : threads) {
            thread.join();
        }
        return totalPower.get();
    }
}
