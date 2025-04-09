package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        System.out.println(getName() + " attacks " + opponent.getName() + " for " + getStrength() + " damage");
    }
}
