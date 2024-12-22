package school.faang.task_48162;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private static final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit can't be null!");
        }

        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;

        List<Thread> threads = new ArrayList<>();
        List<PowerCalculation> calculations = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculation calculation = new PowerCalculation(unit);
            calculations.add(calculation);
            Thread thread = new Thread(calculation);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Поток был прерван", e);
                Thread.currentThread().interrupt();
            }
        }

        for (PowerCalculation calculation : calculations) {
            totalPower += calculation.getPower();
        }

        return totalPower;
    }
}
