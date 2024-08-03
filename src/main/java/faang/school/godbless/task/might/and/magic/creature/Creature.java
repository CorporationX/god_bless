package faang.school.godbless.task.might.and.magic.creature;

import lombok.Data;

@Data
public abstract class Creature {
    protected String name;
    protected int level;
    protected int health;
    protected int damage;
    protected int defence;
    protected int movement;
    protected int quantity;

    protected Creature() {
    }

    protected Creature(String name, int level, int health, int damage,
                       int defence, int movement, int quantity) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.defence = defence;
        this.movement = movement;
        this.quantity = quantity;
    }
}
