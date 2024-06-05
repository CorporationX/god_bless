package faang.school.godbless.bjs2_7777;

import faang.school.godbless.bjs2_7777.default_values.WarriorDefaultValues;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = WarriorDefaultValues.strength;
        this.dexterity = WarriorDefaultValues.dexterity;
        this.intelligence = WarriorDefaultValues.intelligence;
    }

    @Override
    void attack(Character attacked) {
        int damage = this.strength;
        int attackedHealth = attacked.health;
        if (attackedHealth < damage) {
            attacked.health = 0;
        } else {
            attacked.health = attackedHealth - damage;
        }
    }
}