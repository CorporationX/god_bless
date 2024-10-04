package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        if (target.equals(this)) {
            throw new IllegalArgumentException("Себять ударить нельзя, только погладить!!");
        } else {
            target.setHealth(target.getHealth() - super.getAgility());
        }
    }
}
