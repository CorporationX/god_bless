package school.faang.spring3.task_47935;

import lombok.Getter;

public class PowerThread implements Runnable {
    private final Unit unit;
    @Getter
    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
