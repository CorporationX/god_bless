package school.faang.bjs2_91309;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Squad> squadList = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger sumPower = new AtomicInteger();
        squadList.forEach(s -> {
            Thread thread = new Thread(() -> sumPower.addAndGet(s.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        });

        for (Thread thread : threads) {
            thread.join();
        }

        return sumPower.get();



    }

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }
}
