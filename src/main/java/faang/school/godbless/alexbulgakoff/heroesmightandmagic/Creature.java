package faang.school.godbless.alexbulgakoff.heroesmightandmagic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@Getter
@EqualsAndHashCode
@ToString
public abstract class Creature {

    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int count;


    public Creature(String name) {
        this.name = name;
    }

    public Creature(String name, int level, int attack, int defense, int speed, int count) {
        this(name);
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.count = count;
    }

    public int getDamage() {
        return (attack * speed) - defense;
    }
}
