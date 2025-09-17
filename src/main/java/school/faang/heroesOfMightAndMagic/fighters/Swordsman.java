package school.faang.heroesOfMightAndMagic.fighters;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Swordsman implements Fighter {
    private int power = 50;
    private int health = 125;

    public Swordsman(int power) {
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
