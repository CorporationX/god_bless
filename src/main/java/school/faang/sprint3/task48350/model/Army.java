package school.faang.sprint3.task48350.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Warrior> warriors = new ArrayList<>();

    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        AtomicInteger overallPower = new AtomicInteger();
        Thread[] threads = new Thread[warriors.size()];
        int i = 0;
        for (Warrior warrior : warriors) {
            threads[i] = new Thread(
                    () -> {
                        overallPower.addAndGet(warrior.getPower());
                        System.out.println("Calc power of " + warrior.getType());
                    }
            );
            threads[i].start();
            i++;
        }

        for (i = 0; i < warriors.size(); i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Overall army's power calculated!");
        return overallPower.get();
    }
}
