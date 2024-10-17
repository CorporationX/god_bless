package school.faang.armyofheros;

import lombok.Getter;

@Getter
public class PowerCalculator extends Thread{
    private final Character character;
    private int power;

    public PowerCalculator(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }
}
