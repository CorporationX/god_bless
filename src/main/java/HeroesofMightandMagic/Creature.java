package HeroesofMightandMagic;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int amount;

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public int amount() {
        return amount;
    }
}
