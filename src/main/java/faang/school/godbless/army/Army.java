package faang.school.godbless.army;

import java.util.LinkedList;
import java.util.List;

public class Army {
    private final List<Unit> units = new LinkedList<>();
    private int totalPower;

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    private synchronized void increaseTotalPower(Unit unit) {
        totalPower += unit.getPower();
        System.out.println(Thread.currentThread().getName() +
                " increased total power to " + totalPower + " by adding " + unit.getPower());
    }

    public int calculateTotalPower() throws InterruptedException {
        Thread[] threads = new Thread[units.size()];

        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> increaseTotalPower(units.get(finalI)));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return totalPower;
    }
}
