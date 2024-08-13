package faang.school.godbless.battle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Creature {
    protected String name;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int health = 100;

    public Creature(String name) {
        this.name = name;
    }

    public abstract int getDamage();

    public void attack(Creature target) {
        target.health -= this.getDamage();
    }
}
