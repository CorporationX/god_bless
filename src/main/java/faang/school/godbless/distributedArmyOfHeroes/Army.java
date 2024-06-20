package faang.school.godbless.distributedArmyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Subdivision> subdivisions;

    public Army() {
        this.subdivisions = new ArrayList<>();
    }

    public void addUnit(Subdivision subdivision) {
        subdivisions.add(subdivision);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> power = new ArrayList<>();

        for (Subdivision subdivision : subdivisions) {
            Thread thread = new Thread(() -> power.add(subdivision.getPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return power.stream()
                .mapToInt(num -> num)
                .sum();
    }
}