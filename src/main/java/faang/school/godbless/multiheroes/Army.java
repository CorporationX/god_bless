package faang.school.godbless.multiheroes;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Unit> UNITS = new ArrayList<>();

    public int calculateTotalPower() {
        List<PowerCalculatorThread> threads = new ArrayList<>();
        int totalPower = 0;
        for (var unit : UNITS) {
            PowerCalculatorThread calculator = new PowerCalculatorThread(unit);
            calculator.start();
            threads.add(calculator);
        }
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += thread.getPower();
        }
        return totalPower;
    }

    public void addUnit(Unit unit) {
        UNITS.add(unit);
    }
}
