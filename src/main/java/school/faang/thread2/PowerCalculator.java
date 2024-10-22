package school.faang.thread2;

import lombok.Getter;

@Getter
public class PowerCalculator implements Runnable {
    private final Soldier soldier;
    private int power;

    public PowerCalculator(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void run() {
        this.power = soldier.getPower();
    }
}

