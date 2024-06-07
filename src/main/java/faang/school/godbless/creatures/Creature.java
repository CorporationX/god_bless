package faang.school.godbless.creatures;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Creature {
    protected String name;
    protected int damage;
    protected int level;
    protected int speed;
    protected int protection;
    protected int health;

    public Creature(String name) {
        this.name = name;
    }

    public abstract int getDamage();
}