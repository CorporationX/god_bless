package school.faang.bjs2_81193;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> armySquads = new ArrayList<>();

    public void addSquad(Squad squad) {
        armySquads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalArmyPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : armySquads) {
            Thread thread = new Thread(() -> totalArmyPower.addAndGet(squad.calculateSquadPower()));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return totalArmyPower.get();
    }

}
