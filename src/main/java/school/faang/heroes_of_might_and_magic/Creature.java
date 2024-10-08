package school.faang.heroes_of_might_and_magic;

import lombok.Data;

@Data
public abstract class Creature {
    private final String name;
    private final int level;
    private final int attack;
    private final int protection;
    private final int speed;

    public abstract int getDamage();
}
