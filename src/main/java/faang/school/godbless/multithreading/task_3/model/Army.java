package faang.school.godbless.multithreading.task_3.model;

import faang.school.godbless.multithreading.task_3.util.UnitPowerCalculator;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<UnitPowerCalculator>  unitPowerCalculators = getUnitPowerCalculatorThreads();
        for (UnitPowerCalculator unitPowerCalculator : unitPowerCalculators) {
            unitPowerCalculator.join();
            int unitPower = unitPowerCalculator.getPower();
            totalPower += unitPower;
        }
        return totalPower;
    }

    private List<UnitPowerCalculator> getUnitPowerCalculatorThreads() {
        List<UnitPowerCalculator>  unitPowerCalculators = new ArrayList<>();
        for (Unit unit : units) {
            UnitPowerCalculator unitPowerCalculator = new UnitPowerCalculator(unit);
            unitPowerCalculator.start();
            unitPowerCalculators.add(unitPowerCalculator);
            System.out.println(unitPowerCalculator.getName() + " начал свою работу");
        }
        return unitPowerCalculators;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
