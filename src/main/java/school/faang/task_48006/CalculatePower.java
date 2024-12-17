package school.faang.task_48006;

import lombok.Getter;

public class CalculatePower implements Runnable {

    private final Unit unit;
    @Getter
    private int power;

    public CalculatePower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}