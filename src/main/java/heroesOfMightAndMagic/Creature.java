package heroesOfMightAndMagic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Creature {
    private int health;
    private String name;
    private int attack;
    private int hpAfterAttack;

    public Creature(String name, int attack, int health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.hpAfterAttack = 0;
    }

    public int getDamage() {
        return this.attack;
    }
}
