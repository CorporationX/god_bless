package school.faang.magicAndMight2;

import lombok.Getter;

@Getter
public class Swordsman extends Unit{
    private static final int DEFAULT_POWER = 30;

    public Swordsman() {
        super(DEFAULT_POWER);
    }
}
