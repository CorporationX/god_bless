package school.faang.bjs248436;

import lombok.Getter;

public class PowerCalculator implements Runnable {

    private Fighter fighter;
    @Getter
    private int power;

    public PowerCalculator(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void run() {
        power = fighter.getPower();
    }

}
