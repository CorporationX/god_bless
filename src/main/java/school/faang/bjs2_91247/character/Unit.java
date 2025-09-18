package school.faang.bjs2_91247.character;

import lombok.Getter;

import java.util.Random;

@Getter
public abstract class Unit {
    private final int power;

    private static final Random POWER_RANGE = new Random();

    public Unit(int minPower, int maxPower) {
        this.power = POWER_RANGE.nextInt(minPower, maxPower + 1);
    }
}