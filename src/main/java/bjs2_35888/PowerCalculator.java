package bjs2_35888;

import lombok.Getter;

public class PowerCalculator implements Runnable {
    Warrior warrior;
    @Getter
    private int power;

    public PowerCalculator(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        this.power = warrior.getPower();
    }
}
