package school.faang.heroes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode
@ToString
public class Army {
    private final List<Squad> squads = new CopyOnWriteArrayList<>();
    private final AtomicInteger totalPower = new AtomicInteger(0);

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        totalPower.set(0);
        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                int power = squad.calculateSquadPower();
                totalPower.addAndGet(power);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower.get();
    }
}
