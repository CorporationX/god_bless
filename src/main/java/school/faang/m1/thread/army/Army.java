package school.faang.m1.thread.army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Squad> squadList = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad != null) {
            squadList.add(squad);
        }
    }

    public int calculateTotalPower() {
        if (squadList.isEmpty()) {
            return 0;
        }

        final int n = squadList.size();
        List<Thread> threads = new ArrayList<>(n);

        AtomicInteger result = new AtomicInteger();
        for (Squad squad : squadList) {
            Thread t = new Thread(() -> result.addAndGet(squad.calculateSquadPower()));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted while waiting squad threads", e);
            }
        }

        return result.get();
    }

}
