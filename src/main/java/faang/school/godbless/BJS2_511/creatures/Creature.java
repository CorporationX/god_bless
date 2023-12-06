package faang.school.godbless.BJS2_511.creatures;

import lombok.Data;

@Data
public abstract class Creature {
    private String name;
    private int laval;
    private int damage;
    private int defence;
    private int speed;
    private int quantity;

    public Creature(String name, int laval, int damage, int defence, int speed, int quantity) {
        this.name = name;
        this.laval = laval;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
        this.quantity = quantity;
    }

    public int getDamage() {
        return this.damage;
    }
}
