package faang.school.godbless;

import lombok.Data;

@Data
abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    Character(String name) {
        this.name = name;
    }

    Character(String name, int strength, int agility, int intelligence) {
        this(name);

        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    void takeHealthDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    abstract void attack(Character enemy);
}
