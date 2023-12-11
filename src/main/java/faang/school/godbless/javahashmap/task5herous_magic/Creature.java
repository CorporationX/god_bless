package faang.school.godbless.javahashmap.task5herous_magic;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class Creature {
    private String name;
    private int level;
    private int hp;
    private int damage;
    private int defend;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int hp, int damage, int defend, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.hp = hp;
        this.defend = defend;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attack=" + damage +
                ", defend=" + defend +
                ", speed=" + speed +
                ", quantity=" + quantity +
                '}';
    }
}
