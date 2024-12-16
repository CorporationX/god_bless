package school.faang.magic_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> armyUnits = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyUnits.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> PowerCounter = new ArrayList<>();

        armyUnits.forEach(unit -> { Thread powerCounter = new PowerCounter(unit);
            PowerCounter.add(powerCounter);
            powerCounter.start();
        });

        for (Thread thread : PowerCounter) {
            try {
                thread.join();
                totalPower += thread.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalPower;
    }
}
