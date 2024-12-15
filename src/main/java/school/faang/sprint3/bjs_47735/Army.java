package school.faang.sprint3.bjs_47735;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Warrior> units = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        units.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger sumPower = new AtomicInteger();

        for (Warrior warrior : units) {
            Thread thread = new Thread(() -> sumPower.addAndGet(warrior.getPower()));
            thread.start();
            thread.join();
        }

        return sumPower.get();
    }
}
