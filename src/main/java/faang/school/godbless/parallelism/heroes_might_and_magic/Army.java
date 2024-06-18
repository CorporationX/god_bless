package faang.school.godbless.parallelism.heroes_might_and_magic;

import faang.school.godbless.parallelism.heroes_might_and_magic.entity.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<PowerThread> threads = new ArrayList<>();
        for (Unit unit : units) {
            PowerThread powerThread = new PowerThread(unit);
            powerThread.start();
            threads.add(powerThread);
        }
        for (PowerThread thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
