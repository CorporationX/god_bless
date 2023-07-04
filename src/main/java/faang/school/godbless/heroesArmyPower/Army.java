package faang.school.godbless.heroesArmyPower;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Army {
    List<UnitPowerThread> threads = new ArrayList<>();

    private final List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Unit unit : units) {
            if (unit.isMage()) {
                startThreads(unit);
            } else if (unit.isArcher()) {
                startThreads(unit);
            } else if (unit.isSwordsman()) {
                startThreads(unit);
            }
        }
        return getTotal();
    }

    private int getTotal() throws InterruptedException {
        return getPowerSum(threads);
    }

    private void startThreads(Unit unit) {
        UnitPowerThread powerThread = new UnitPowerThread(unit);
        threads.add(powerThread);
        powerThread.start();
    }

    private int getPowerSum(List<UnitPowerThread> units) throws InterruptedException {
        int totalPower = 0;
        for (UnitPowerThread thread : units) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}