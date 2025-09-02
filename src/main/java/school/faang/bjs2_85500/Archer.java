package school.faang.bjs2_85500;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntelligence(5);
    }

    @Override
    void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
    }
}
