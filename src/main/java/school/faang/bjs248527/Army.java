package school.faang.bjs248527;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
        log.info("Added unit: {} \n", unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            tasks.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }
        log.info("Total power of the army: {}", totalPower);
        return totalPower;
    }
}
