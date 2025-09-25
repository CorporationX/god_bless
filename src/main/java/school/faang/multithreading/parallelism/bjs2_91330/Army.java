package school.faang.multithreading.parallelism.bjs2_91330;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private List<Squad> squadList = new ArrayList<>();

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }

    public int calculateTotalPower() {
        AtomicInteger sum = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        squadList.forEach(squad -> {
            Thread thread = new Thread(() -> {
                sum.addAndGet(squad.calculateSquadPower());
            });
            thread.start();
            threads.add(thread);
        });

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        return sum.get();
    }
}
