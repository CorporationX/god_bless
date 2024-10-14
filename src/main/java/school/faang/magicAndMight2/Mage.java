package school.faang.magicAndMight2;

import lombok.Getter;

@Getter
public class Mage extends Unit {
    private static final int DEFAULT_POWER = 40;

    public Mage() {
        super(DEFAULT_POWER);
    }
}