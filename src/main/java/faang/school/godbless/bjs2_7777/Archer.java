package faang.school.godbless.bjs2_7777;

import faang.school.godbless.bjs2_7777.default_values.ArcherDefaultValues;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = ArcherDefaultValues.strength;
        this.dexterity = ArcherDefaultValues.dexterity;
        this.intelligence = ArcherDefaultValues.intelligence;
    }

    @Override
    void attack(Character attacked) {
        int damage = this.dexterity;
        int attackedHealth = attacked.health;
        if (attackedHealth < damage) {
            attacked.health = 0;
        } else {
            attacked.health = attackedHealth - damage;
        }
    }
}
