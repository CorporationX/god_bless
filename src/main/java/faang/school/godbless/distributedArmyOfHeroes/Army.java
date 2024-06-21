package faang.school.godbless.distributedArmyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final List<Unit> ARMY = new ArrayList<>();

    private int powerArmy;

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();

        for (Unit unit : ARMY) {
            Thread thread = new Thread(() -> {
                setPowerArmy(unit.getPower() + getPowerArmy());
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return getPowerArmy();
    }

    public void addUnit(Unit unit) {
        ARMY.add(unit);
    }

    public synchronized void setPowerArmy(int powerArmy) {
        this.powerArmy = powerArmy;
    }

    public synchronized int getPowerArmy() {
        return powerArmy;
    }
}
