package heroesOfMightAndMagic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Creature {
    private int health;
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int quantity;
    private int hpAfterAttack;

    public Creature(String name, int level, int attack, int protection, int speed, int health) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.health = health;
        this.quantity = 0;
        this.hpAfterAttack = 0;
    }

    public abstract int getDamage();
}
