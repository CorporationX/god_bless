package school.faang.sprint3.bjs248085;

import lombok.Getter;

@Getter
public class PowerCalculator implements Runnable {
    private final Warrior warrior;
    private int power;

    public PowerCalculator(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        this.power = warrior.getPower();
    }
}