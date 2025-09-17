package school.faang.heroesOfMightAndMagic.fighters;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Archer implements Fighter {
    private int power = 25;
    private int health = 100;

    public Archer(int power) {
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
