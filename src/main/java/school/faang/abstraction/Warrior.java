package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        if (target.equals(this)) {
            throw new IllegalArgumentException("Себять ударить нельзя, только погладить!!");
        } else {
            target.setHealth(target.getHealth() - super.getStrength());
        }
    }
}
