package school.faang.homm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;

    public abstract Integer getAmountOfDamage();
}
