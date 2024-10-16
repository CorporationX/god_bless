package school.faang.BJS235895;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    public List<Warrior> units = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        units.add(warrior);
    }

    public AtomicInteger calculateTotalPower() {
        List<MyThreads> threads = new ArrayList<>();
        units.forEach(warrior -> threads.add(new MyThreads(warrior)));

        AtomicInteger totalPower = new AtomicInteger();
        threads.forEach(thread -> {
            try {
                thread.start();
                thread.join();
                totalPower.addAndGet(thread.getTotalPower());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        return totalPower;
    }
}
