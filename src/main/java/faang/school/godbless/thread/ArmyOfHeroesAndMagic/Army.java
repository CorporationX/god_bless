package faang.school.godbless.thread.ArmyOfHeroesAndMagic;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {
            threads.add(new UnitThread(unit));
        }

        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        return UnitThread.getTotalPower();
    }
}
