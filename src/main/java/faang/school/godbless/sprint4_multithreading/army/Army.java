package faang.school.godbless.sprint4_multithreading.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerThread> threads = new ArrayList<>();
        for (Unit unit : units) {
            PowerThread thread = new PowerThread(units);
            thread.start();
            threads.add(thread);
        }
        for (PowerThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getUnitPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
