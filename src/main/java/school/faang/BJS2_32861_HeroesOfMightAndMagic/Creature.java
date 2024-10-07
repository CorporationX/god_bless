package school.faang.BJS2_32861_HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class Creature {
    @Getter
    protected final String name;
    protected int level;
    protected int attack;
    protected int defence;
    protected int speed;

    public abstract int getDamage();
}
