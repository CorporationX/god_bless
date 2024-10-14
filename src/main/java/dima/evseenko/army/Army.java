package dima.evseenko.army;

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
        List<PowerCalculatorThread> threads = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculatorThread thread = new PowerCalculatorThread(unit);
            threads.add(thread);
            thread.start();
        }

        for (PowerCalculatorThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower;
    }
}
