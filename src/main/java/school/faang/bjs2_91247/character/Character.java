package school.faang.bjs2_91247.character;

import lombok.Getter;

import java.util.Random;

@Getter
public abstract class Character {
    private final int power;

    private static final Random POWER_RANGE = new Random();

    public Character(int minPower, int maxPower) {
        this.power = POWER_RANGE.nextInt(minPower, maxPower + 1);
    }
}