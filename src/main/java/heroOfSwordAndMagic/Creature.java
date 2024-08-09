package heroOfSwordAndMagic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Creature {
    protected String name;
    protected int lvl;
    protected int damage;
    protected int defense;
    protected int speed;

    public Creature(String name) {
        this.name = name;
    }

    public Creature(String name, int lvl, int damage, int defense, int speed) {
        this.name = name;
        this.lvl = lvl;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
    }


}
