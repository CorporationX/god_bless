package school.faang.army;

import lombok.Getter;

public class ArmyRunnableCalculator implements Runnable {
    private final Fighter fighter;

    @Getter
    private int power;

    public ArmyRunnableCalculator(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void run() {
        this.power = fighter.getPower();
    }

}
