package school.faang.magicAndMight2;

import lombok.Getter;

@Getter
public class Archer extends Unit {
    private static final int DEFAULT_POWER = 50;

    public Archer() {
        super(DEFAULT_POWER);
    }
}