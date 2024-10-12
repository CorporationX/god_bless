package school.faang.BJS2_32902.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class Creature {
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
        return attack * quantity;
    }

    public void takeDamage(int damage) {
        int killed = damage / (defense * level);
        this.quantity = Math.max(this.quantity - killed, 0);
    }
}
