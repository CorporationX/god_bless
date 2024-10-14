package bjs2_35888;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Warrior> warriors;

    public Army() {
        this.warriors = new ArrayList<>();
    }

    public void recruiting(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<PowerCalculator> calculations = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (Warrior warrior : warriors) {
            PowerCalculator powerCalculator = new PowerCalculator(warrior);
            calculations.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator calculation : calculations) {
            totalPower += calculation.getPower();
        }

        return totalPower;
    }
}
