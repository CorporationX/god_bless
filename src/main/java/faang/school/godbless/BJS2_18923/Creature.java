package faang.school.godbless.BJS2_18923;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature {
    private final double DAMAGE_COEFFICIENT = 0.3;
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int attack, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public int getDamage() {
        return (int) (((attack + speed + level)*quantity) * DAMAGE_COEFFICIENT);
    }
}
