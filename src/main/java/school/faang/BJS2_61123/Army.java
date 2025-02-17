package school.faang.BJS2_61123;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> listSquads;

    public Army() {
        this.listSquads = new ArrayList<>();
    }

    public void addSquad(Squad squad) {
        listSquads.add(squad);
    }

    public int calculateTotalPower() {
        AtomicInteger result = new AtomicInteger(0);
        Object lock = new Object();
        Thread[] threads = new Thread[listSquads.size()];

        for (int i = 0; i < threads.length; i++) {
            final Squad squad = listSquads.get(i);
            threads[i] = new Thread(() -> {
                int squadPower = squad.calculateSquadPower();
                synchronized (lock) {
                    result.addAndGet(squadPower);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + ex.getMessage());
            }
        }

        return result.intValue();
    }
}
