package school.faang.armyofheroes;

import lombok.Getter;

@Getter
public class Mage extends Hero {
    private static final int MAGE_POWER = 50;

    public Mage() {
        super(MAGE_POWER);
    }
}
