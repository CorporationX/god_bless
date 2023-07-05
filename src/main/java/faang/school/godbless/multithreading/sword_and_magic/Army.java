package faang.school.godbless.multithreading.sword_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army;

    public Army() {
        army = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<UnitThread> unitThreads = army.stream()
                .map(UnitThread::new)
                .peek(Thread::start)
                .toList();

        for (UnitThread unitThread : unitThreads) {
            unitThread.join();
        }

        return unitThreads.stream()
                .mapToInt(UnitThread::getUnitPower)
                .sum();
    }
}
