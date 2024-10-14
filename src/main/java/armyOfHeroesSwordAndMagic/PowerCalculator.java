package armyOfHeroesSwordAndMagic;

import lombok.Getter;

public class PowerCalculator implements Runnable {

    private final Character character;
    @Getter
    private int power;

    public PowerCalculator(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }
}
