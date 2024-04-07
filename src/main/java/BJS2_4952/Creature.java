package BJS2_4952;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int healthPoint;
    private int haste;
    private int count;

    public Creature(String name, int level, int attack, int healthPoint, int haste) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.healthPoint = healthPoint;
        this.haste = haste;
    }

    public abstract int getDamage();
}
