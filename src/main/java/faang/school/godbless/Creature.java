package faang.school.godbless;

import lombok.Getter;

@Getter
abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int quantity;

    public Creature(String name, int level, int attack, int defense, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
    }

    public abstract int getDamage();

    @Override
    public String toString() {
        return name + " (Level: " + level + ", Attack: " + attack + ", Defense: " + defense + ", Speed: " + speed + ", Quantity: " + quantity + ")";
    }
}
