package school.faang.armyofheroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    ArrayList<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> unitThreads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            tasks.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
            unitThreads.add(thread);
            thread.start();
        }

        for (Thread unitThread : unitThreads) {
            unitThread.join();
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }
}
