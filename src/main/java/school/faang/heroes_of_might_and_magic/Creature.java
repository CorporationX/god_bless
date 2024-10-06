package school.faang.heroes_of_might_and_magic;

import lombok.Data;

@Data
public abstract class Creature {
    private final String name;
    private final Integer level;
    private final Integer attack;
    private final Integer protection;
    private final Integer speed;

    public abstract int getDamage();
}
