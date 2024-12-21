package school.faang.bjs248436;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Fighter> fighters = new ArrayList<>();

    public void addUnit(Fighter fighter) {
        fighters.add(fighter);
    }

    public int calculateTotalPower() throws Exception {
        int result = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> powerCalculators = new ArrayList<>();
        PowerCalculator powerCalculator;
        Thread thread;
        for (Fighter fighter : fighters) {
            powerCalculator = new PowerCalculator(fighter);
            powerCalculators.add(powerCalculator);
            thread = new Thread(powerCalculator);
            threads.add(thread);
            thread.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        for (PowerCalculator task : powerCalculators) {
            result += task.getPower();
        }
        return result;
    }

}
