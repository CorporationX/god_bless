package faang.school.godbless.heroes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Creature {

    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;

    @Getter
    @Setter
    private int quantity;

    public Creature(String name, int level, int damage, int defence, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

}
