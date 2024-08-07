package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);

        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    public Warrior(String name, int strength, int agility, int intelligence, int health) {
        super(name, strength, agility, intelligence, health);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - this.strength;
    }
}
