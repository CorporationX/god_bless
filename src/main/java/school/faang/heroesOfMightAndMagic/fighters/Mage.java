package school.faang.heroesOfMightAndMagic.fighters;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Mage implements Fighter {
    private int power = 40;
    private int health = 150;

    public Mage(int power) {
        this.power = power;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getPower() {
        return power;
    }
}
