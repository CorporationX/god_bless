package school.faang.bjs281213;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Squad> list = new ArrayList<>();

    public void addSquad(Squad squad) {
        list.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        int threadsCount = list.size();
        Thread[] threads = new Thread[threadsCount];
        AtomicInteger result = new AtomicInteger(0);
        for (int i = 0; i < threadsCount; i++) {
            final int frozen = i;
            threads[frozen] = new Thread(() -> {
                int powerSquad = list.get(frozen).calculatePowerSquad();
                result.addAndGet(powerSquad);
            });
            threads[frozen].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return result.get();
    }
}
