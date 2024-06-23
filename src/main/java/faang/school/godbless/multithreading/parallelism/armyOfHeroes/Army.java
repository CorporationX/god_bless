package faang.school.godbless.multithreading.parallelism.armyOfHeroes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit != null) {
            units.add(unit);
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<UnitThread> threads = new ArrayList<>();

        for (Unit unit : units) {
            UnitThread thread = new UnitThread(unit);
            thread.start();
            threads.add(thread);
        }

        for (UnitThread thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }

        return totalPower;
    }
}
