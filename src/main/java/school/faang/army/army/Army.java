package school.faang.army.army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads;

    public Army(List<Squad> squads) {
        this.squads = squads != null ? squads : new ArrayList<>();
    }

    public synchronized void addSquad(Squad squad) {
        if (squad != null) {
            squads.add(squad);
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> totalPower.addAndGet(squad.calculateSquadPower()));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return totalPower.get();
    }
}