package school.faang.BJS2_35894.wars;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> army = new ArrayList<>();
    private int armyDamage = 0;

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : army) {
            int power = unit.getPower();
            Thread thread = new Thread(() -> armyDamage = armyDamage + power);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return armyDamage;
    }
}
