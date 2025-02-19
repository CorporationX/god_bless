package school.faang.sprint.third.army;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(@NonNull Squad squad) {
        this.squads.add(squad);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> totalPower.addAndGet(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower.get();
    }
}
