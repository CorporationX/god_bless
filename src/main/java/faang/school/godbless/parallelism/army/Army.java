package faang.school.godbless.parallelism.army;

import faang.school.godbless.parallelism.army.soldiers.Soldier;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Soldier> soldierList = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<Integer> calculates = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (Soldier soldier : soldierList) {
            Thread thread = new Thread(() -> calculates.add(soldier.getPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return calculates.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }

    public void addUnit(Soldier soldier) {
        soldierList.add(soldier);
    }
}
