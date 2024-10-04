package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character defender) {
        defender.setHealth(defender.getHealth() - getStrength());
    }
}
