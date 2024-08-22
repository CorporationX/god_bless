package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        int[] totalPower = {0};

        units.forEach(unit -> {
            Thread thread = new Thread(() -> {
                synchronized (totalPower) {
                    totalPower[0] += unit.getPower();
                }
            });
            threads.add(thread);
            thread.start();
        });

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        return totalPower[0];
    }
}
