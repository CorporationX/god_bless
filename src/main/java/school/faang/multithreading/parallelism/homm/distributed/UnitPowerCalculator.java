package school.faang.multithreading.parallelism.homm.distributed;

import lombok.Getter;

public class UnitPowerCalculator extends Thread{
    private Unit unit;

    @Getter
    private int unitPower;

    public UnitPowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void start() {
        unitPower = unit.getPower();
    }
}
