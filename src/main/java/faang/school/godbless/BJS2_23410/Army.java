package faang.school.godbless.BJS2_23410;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Army {
    private List<Unit> armyList = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyList.add(unit);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();

        for (Unit unit : armyList) {
            Thread thread = new Thread(() -> totalPower.addAndGet(unit.getPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower.get();
    }
}
