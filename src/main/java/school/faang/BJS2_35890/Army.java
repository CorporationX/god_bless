package school.faang.BJS2_35890;

import school.faang.BJS2_35890.entity.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<PowerCalculator> calculators = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            calculators.add(calculator);
            calculator.start();
        }

        int totalPower = 0;
        for (PowerCalculator calculator : calculators) {
            calculator.join();
            totalPower += calculator.getResult();
        }

        return totalPower;
    }
}
