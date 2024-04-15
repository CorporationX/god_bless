package faang.school.godbless.HerosAndMagicArmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army;

    public Army() {
        this.army = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        List<UnitThread> threads = new ArrayList<>();
        for (Unit unit : army) {
            UnitThread thread = new UnitThread(unit);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;
        for (UnitThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower;
    }
}
