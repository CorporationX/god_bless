package school.faang.armyofheroes;

import lombok.Getter;

@Getter
public class Archer extends Hero {
    private static final int ARCHER_POWER = 25;

    public Archer() {
        super(ARCHER_POWER);
    }
}
