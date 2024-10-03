package school.faang.abstraction_BJS2_31286;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - super.dexterity;
    }

}
