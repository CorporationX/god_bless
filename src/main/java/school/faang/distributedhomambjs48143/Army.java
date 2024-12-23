package school.faang.distributedhomambjs48143;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Warrior> units;

    public Army() {
        units = new ArrayList<>();
    }

    public void addUnit(Warrior unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        Thread[] threads = new Thread[units.size()];
        int[] powers = new int[units.size()];

        for (int i = 0; i < units.size(); i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                powers[index] = units.get(index).getPower();
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        for (int power : powers) {
            totalPower += power;
        }
        return totalPower;
    }
}
