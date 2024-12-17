package school.faang.bjs247633;

import lombok.Getter;

@Getter
public class TheadForCalculation extends Thread {
    private final Fighter fighter;
    private int power;

    public TheadForCalculation(Fighter fighter) {
        this.fighter = fighter;
    }

    public void run() {
        this.power = fighter.getPower();
    }
}