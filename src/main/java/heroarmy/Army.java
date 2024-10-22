package heroarmy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();
        int totalPower = 0;

        for (Unit unit : units) {
            PowerCalculator task = new PowerCalculator(unit);
            Thread thread = new Thread(task);
            tasks.add(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }
}
