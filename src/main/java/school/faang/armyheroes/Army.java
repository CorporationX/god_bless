package school.faang.armyheroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> army = new ArrayList<>();

    public Integer calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();
        Integer totalPower = 0;

        for (Unit unit : army) {
            PowerCalculator calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }
}
