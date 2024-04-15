package faang.school.godbless.multithreading.task_3.model;

import faang.school.godbless.multithreading.task_3.util.UnitPowerCalculator;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        for (Unit unit : units) {
            UnitPowerCalculator unitPowerCalculator = new UnitPowerCalculator(unit);
            unitPowerCalculator.start();
            System.out.println(unitPowerCalculator.getName() + " начал свою работу");
            unitPowerCalculator.join();
            totalPower += unitPowerCalculator.getPower();
        }
        return totalPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
