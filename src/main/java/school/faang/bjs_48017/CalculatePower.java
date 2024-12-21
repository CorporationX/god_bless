package school.faang.bjs_48017;

import lombok.Getter;

public class CalculatePower implements Runnable {
    private final Character character;
    @Getter
    private int power;

    public CalculatePower(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        this.power = character.getPower();
    }

}
