package school.faang.sprint_3.task_48341;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : army) {
            PowerCalculator calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток прерван.");
            }
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }
}
