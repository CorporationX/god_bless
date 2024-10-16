package school.faang.multithreading.distributedArmy;

import lombok.Getter;


@Getter
public class PowerCalculation extends Thread {
    private int power;
    private final Unit unit;

    public PowerCalculation(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
