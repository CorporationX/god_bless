package faang.school.godbless.bjs2_4441;

import lombok.Getter;

@Getter
public abstract class Creature {

    private String name;
    private int level;
    private int health;
    private int damage;
    private int armor;
    private int speed;
    private int amount;

    public Creature(String name, int health, int level, int damage, int armor, int speed) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }
}
