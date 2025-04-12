package school.faang.abstraction.models;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, getStrength());
    }

}
