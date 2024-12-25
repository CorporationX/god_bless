package school.faang.task_48369;

import lombok.Getter;

@Getter
public class PowerCalculator implements Runnable {
    private final Unit unit;
    private int power;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
        System.out.println("Thread " + Thread.currentThread().getId() + " calculating power for unit: " + power);
    }

}
