package school.faang.abstraction_BJS2_31286;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.dexterity = 10;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - super.dexterity;
    }

}
