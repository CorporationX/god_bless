package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name);
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        target.health -= this.dexterity;
    }
}
