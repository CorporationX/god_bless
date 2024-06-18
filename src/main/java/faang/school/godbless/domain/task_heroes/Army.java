package faang.school.godbless.domain.task_heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Unit> units = new ArrayList<>();
    int totalPower = 0;

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();

        for (Unit unit : units) {
            threads.add(new Thread(() -> totalPower = totalPower + unit.getPower()));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return totalPower;
    }
}
