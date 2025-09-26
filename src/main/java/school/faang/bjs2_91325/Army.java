package school.faang.bjs2_91325;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private final List<Squad> fullArmy = new ArrayList<>();

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();

        AtomicInteger result = new AtomicInteger(0);
        for (Squad squad : fullArmy) {
            Thread thread = new Thread(() -> result.addAndGet(squad.calculateSquadPower()));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return result.get();
    }
}
