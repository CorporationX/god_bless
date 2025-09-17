package bjs291241;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Squad> army = new ArrayList<>();


    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger armyPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : army) {
            Thread thread = new Thread(new PowerCalculator(squad, armyPower));
            threads.add(thread);
            thread.start();
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
