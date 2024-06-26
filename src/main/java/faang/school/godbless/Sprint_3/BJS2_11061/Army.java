package faang.school.godbless.Sprint_3.BJS2_11061;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();
    private int totalPower = 0;

    public synchronized void addPower(int power) {
        totalPower += power;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (Unit unit : units) {
            Thread thread = new Thread(() -> {
                addPower(unit.getPower());
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower;
    }
}
