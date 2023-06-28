package distributed_army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    List<Hero> heroes;

    public Army() {
        this.heroes = new ArrayList<>();
    }

    public void addUnit(Hero hero) {
        heroes.add(hero);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger totalPower = new AtomicInteger();
        for (Hero hero : heroes) {
            Thread thread = new Thread(() -> {
                int heroPower = hero.getPower();
                synchronized (this) {
                    totalPower.addAndGet(heroPower);
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalPower.get();
    }
}
