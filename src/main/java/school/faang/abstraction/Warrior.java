package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name);
    }

    @Override
    public void attack(Character target) {
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth - this.strength);
    }
}
