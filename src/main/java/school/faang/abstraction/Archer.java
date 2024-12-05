package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        int targetHealth = target.health;
        target.setHealth(targetHealth - this.dexterity);
    }
}
