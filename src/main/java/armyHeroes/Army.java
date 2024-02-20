package armyHeroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Object> warriors = new ArrayList<>();

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (Object warrior : warriors) {
            if (warrior instanceof Archer) {
                Thread thread = new Thread(() -> totalPower.getAndAdd(((Archer) warrior).getPower()));
                threads.add(thread);
                thread.start();
            } else if (warrior instanceof Mage) {
                Thread thread = new Thread(() -> totalPower.getAndAdd(((Mage) warrior).getPower()));
                threads.add(thread);
                thread.start();
            } else {
                Thread thread = new Thread(() -> totalPower.getAndAdd(((Swordsman) warrior).getPower()));
                threads.add(thread);
                thread.start();
            }
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

    public void addUnit(Object warrior) {
        warriors.add(warrior);
    }
}
