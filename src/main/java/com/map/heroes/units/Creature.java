package com.map.heroes.units;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public abstract class Creature {
    private String name;
    private int level;
    private int power;
    private int armor;
    private int speed;
    private int health;
    private int quantity;

    public Creature(String name, int level, int power, int armor, int speed, int health, int quantity) {
        if (!name.isEmpty() && level > 0 && power > 0 && armor > 0 && speed > 0 && health > 0 && quantity > 0) {
            this.name = name;
            this.level = level;
            this.power = power;
            this.armor = armor;
            this.speed = speed;
            this.health = health;
            this.quantity = quantity;
        }else {
            throw new IllegalArgumentException("Argument is not valid");
        }
    }

    public Integer getDamage() {
        return power;
    }
    /*public Integer getArmor() {
        return armor * quantity;
    }*/

}
