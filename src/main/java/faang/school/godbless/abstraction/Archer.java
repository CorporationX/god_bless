package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);

        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    public Archer(String name, int strength, int agility, int intelligence, int health) {
        super(name, strength, agility, intelligence, health);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - this.agility;
    }
}
