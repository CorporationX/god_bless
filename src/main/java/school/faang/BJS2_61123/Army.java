package school.faang.BJS2_61123;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads;

    public Army() {
        this.squads = new ArrayList<>();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        AtomicInteger result = new AtomicInteger(0);
        Thread[] threads = new Thread[squads.size()];

        for (int i = 0; i < threads.length; i++) {
            final Squad squad = squads.get(i);
            threads[i] = new Thread(() -> {
                int squadPower = squad.calculateSquadPower();
                result.addAndGet(squadPower);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + ex.getMessage());
                throw new RuntimeException("Thread join was interrupted", ex);
            }
        }

        return result.intValue();
    }
}
