package faang.school.godbless.armyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<UnitPowerCalculator> calculators = new ArrayList<>();

        for (Unit unit : units) {
            UnitPowerCalculator calculator = new UnitPowerCalculator(unit);
            calculators.add(calculator);
            calculator.start();
        }

        int totalPower = 0;
        for (UnitPowerCalculator calculator : calculators) {
            try {
                calculator.join();
                totalPower += calculator.getPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalPower;
    }
}
