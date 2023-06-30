package faang.school.godbless.MightAndMagicThreads;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Division> divisions;
    private volatile int totalPower;

    public Army() {
        this.divisions = new ArrayList<>();
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (Division division : divisions) {
            Thread thread = new Thread(() -> {
                addPower(division.getPower());
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower;
    }

    public synchronized void addPower(int powerToAdd) {
        this.totalPower += powerToAdd;
    }

    public void addUnit(Division division) {
        this.divisions.add(division);
    }
}
