package bjs291241;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Squad> army = new ArrayList<>();


    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger armyPower = new AtomicInteger(0);
        Thread[] threads = new Thread[army.size()];
        for (int i = 0; i < army.size(); i++) {
            Squad squad = army.get(i);
            threads[i] = new Thread(new PowerCalculator(squad, armyPower));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return armyPower.get();
    }

    public void addSquad(Squad squad) {
        army.add(squad);
    }
}
