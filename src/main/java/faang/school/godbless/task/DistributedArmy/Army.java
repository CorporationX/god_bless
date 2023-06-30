package faang.school.godbless.task.DistributedArmy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (Soldier soldier : soldiers) {
            threads.add(new Thread(() -> totalPower.addAndGet(soldier.getPower())));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower.get();
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }
}
