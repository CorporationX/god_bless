package faang.school.godbless.DistributedArmyOfSwordAndMagicHeroes;

import lombok.Getter;

@Getter
public class PowerCalculator implements Runnable {

    private final Character character;
    private int power;

    public PowerCalculator(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        this.power = character.getPower();
    }

}
