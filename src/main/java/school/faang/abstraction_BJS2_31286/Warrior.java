package school.faang.abstraction_BJS2_31286;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.dexterity = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - super.strength;
    }

}
