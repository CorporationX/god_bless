package school.faang.abstraction.models;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, getAgility());
    }
}
