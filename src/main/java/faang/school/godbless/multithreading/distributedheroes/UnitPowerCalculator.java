package faang.school.godbless.multithreading.distributedheroes;

import lombok.Getter;

@Getter
public class UnitPowerCalculator extends Thread {

    private int power;
    private final Unit unit;

    public UnitPowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }

}
