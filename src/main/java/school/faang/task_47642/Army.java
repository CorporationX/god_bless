package school.faang.task_47642;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Unit> units = new ArrayList<>();


    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ошибка в работе потоков" + e.getMessage());
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }
        return totalPower;
    }
}
