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
        PowerCalculator task;
        Thread thread;

        for (Unit unit : units) {
            task = new PowerCalculator(unit);
            thread = new Thread(task);
            tasks.add(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread currentThread : threads) {
            try {
                currentThread.join();
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Что-то пошло не так при вызове метода join().");
            }
        }

        for (PowerCalculator currentTask : tasks) {
            totalPower += currentTask.getPower();
        }

        return totalPower;
    }
}
