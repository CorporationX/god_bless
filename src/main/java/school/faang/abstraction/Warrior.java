package school.faang.abstraction;

public class Warrior extends Character{
    public Warrior(String name) {
        super(10,  5,  3);
        this.setName(name);
    }

    @Override
    public void attack(Character defender) {
        defender.setHealth(defender.getHealth() - this.getStrength());
    }
}