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

    public int calculateTotalPower() {
//        Не пойму, почему в таком случае, не считает нормально, выдает 0)
//        return army.parallelStream()
//                .map(UnitThread::new)
//                .peek(Thread::start)
//                .mapToInt(UnitThread::getUnitPower)
//                .sum();

        List<UnitThread> unitThreads = army.parallelStream()
                .map(UnitThread::new)
                .peek(Thread::start)
                .toList();

        return unitThreads.stream()
                .mapToInt(UnitThread::getUnitPower)
                .sum();
    }
}
