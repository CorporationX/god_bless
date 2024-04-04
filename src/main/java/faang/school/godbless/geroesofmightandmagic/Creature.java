package faang.school.godbless.geroesofmightandmagic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Creature {

    private final String name;
    private final int level;
    private final int attack;
    private final int defence;
    private final int speed;
    private int count;

    public Creature(String name, int level, int attack, int defence, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public int getDamage() {
        return attack * count;
    }

    public int getDamageReduction() {
        return defence * count;
    }
}
