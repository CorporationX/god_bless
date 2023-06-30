package faang.school.godbless.MightAndMagicThreads;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Division> divisions;
    private Integer totalPower;

    public Army() {
        this.totalPower = 0;
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

    public void addPower(int powerToAdd) {
        this.totalPower += powerToAdd;
    }

    public void addUnit(Division division) {
        this.divisions.add(division);
    }
}
