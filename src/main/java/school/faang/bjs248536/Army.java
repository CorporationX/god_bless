package school.faang.bjs248536;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit can not be null");
        }
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();
        PowerCalculator calculator;
        Thread thread;

        for (Unit unit : units) {
            calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread currentThread : threads) {
            currentThread.join();

        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }
        return totalPower;
    }
}
