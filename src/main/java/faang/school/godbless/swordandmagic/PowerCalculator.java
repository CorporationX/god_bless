package faang.school.godbless.swordandmagic;

import lombok.Getter;

@Getter
public class PowerCalculator extends Thread {

    private int power;
    private final Character character;

    public PowerCalculator(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }

}
