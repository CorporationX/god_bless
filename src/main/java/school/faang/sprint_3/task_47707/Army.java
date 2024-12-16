package school.faang.sprint_3.task_47707;

import java.util.ArrayList;
import java.util.List;

public class Army {
    static List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Герой не может быть пустым (null)");
        }
        if (units == null) {
            throw new NullPointerException("Список не может быть null");
        }
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        if (units == null) {
            throw new NullPointerException("Список не может быть null");
        }

        for (Unit unit : units) {
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
                Thread.currentThread().interrupt();
                throw new RuntimeException("Прерывание вложенного потока при ожидании завершения" + e.getMessage());
            }
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }
        return totalPower;
    }
}
