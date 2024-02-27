package multithreadingPart1.armyHeroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Hero> warriors = new ArrayList<>();

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (Hero hero : warriors) {
            Thread thread = new Thread(() -> totalPower.addAndGet(hero.getPower()));
            thread.start();
            threads.add(thread);
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return totalPower.get();
    }

    public void addUnit(Hero warrior) {
        warriors.add(warrior);
    }
}
