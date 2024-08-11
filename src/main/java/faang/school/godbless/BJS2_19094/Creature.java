package faang.school.godbless.BJS2_19094;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
abstract class Creature {
    @Getter
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;

    public abstract int getDamage();
}
