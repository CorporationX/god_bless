package faang.school.godbless.BJS2_23410;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private List<Unit> armyList = new ArrayList<>();
    private int totalPower;

    public void addUnit(Unit unit) {
        armyList.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : armyList) {
            threads.add(new Thread(() -> totalPower += unit.getPower()));
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
