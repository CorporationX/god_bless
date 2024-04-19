package faang.school.godbless.multithreading.task_3.util;

import faang.school.godbless.multithreading.task_3.model.Unit;

public class UnitPowerCalculator extends Thread {
    private final Unit unit;
    private int power;

    public UnitPowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
       power = unit.getPower();
    }

    public int getPower() {
        return power;
    }
}
