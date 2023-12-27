package faang.school.godbless.BJS2_1092;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Army {
    private final Map<Creature, Integer> groupedArmy = new HashMap<>();
    private int totalPower;

    public void addUnit(Creature creature) {
        groupedArmy.merge(creature, 1, Integer::sum);
    }

    public void calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        for (var unit : groupedArmy.entrySet()) {
            Thread thread = new Thread(() -> {
                System.out.println("Calculating power for " + unit.getKey().getName() + " in thread " + Thread.currentThread());
                synchronized (this) {
                    totalPower += unit.getKey().getPower() * unit.getValue();
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}