package faang.school.godbless;

import lombok.Getter;

@Getter
abstract class Creature {
    private String name;
    private int level;
    private int defense;
    private int attack;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int defense, int attack, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.defense = defense;
        this.attack = attack;
        this.speed = speed;
        this.quantity = quantity;
    }

    public int getDamage(){
        return (attack - defense) * quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void removeQuantity(int amount) {
        this.quantity -= amount;
        if (this.quantity < 0) this.quantity = 0;
    }

    @Override
    public String toString() {
        return name + " (x" + quantity + ")";
    }
}
