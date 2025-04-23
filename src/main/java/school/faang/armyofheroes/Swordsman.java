package school.faang.armyofheroes;

import lombok.Getter;

@Getter
public class Swordsman extends Hero {
    private static final int SWORDSMAN_POWER = 25;

    public Swordsman() {
        super(SWORDSMAN_POWER);
    }
}
