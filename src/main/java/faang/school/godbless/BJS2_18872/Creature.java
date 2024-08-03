package faang.school.godbless.BJS2_18872;

import lombok.Getter;

public abstract class Creature {
    protected String name;
    protected int level;
    @Getter
    protected int damage;
    protected int protection;
    protected int speed;
    protected int quantity;

    public Creature(String name, int level, int damage, int protection, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.protection = protection;
        this.speed = speed;
        this.quantity = quantity;
    }

}
