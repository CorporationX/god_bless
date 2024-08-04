package com.map.heroes.units;

import com.map.heroes.units.Creature;

public class Swordman extends Creature {
    public Swordman(String name, int level, int power, int armor, int speed, int health, int quantity) {
        super(name, level, power, armor, speed, health, quantity);
    }

    @Override
    public Integer getDamage() {
        return super.getDamage();
    }
}
