package faang.school.godbless.homm;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {

    private final List<Unit> army = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger();
        for (Unit unit : army) {
            Thread thread = new Thread(() -> totalPower.addAndGet(unit.getPower()));
            thread.start();
            thread.join();
        }
        return totalPower.get();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }
}
