package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(5);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    void attack(Character opponent) {
        int archersAgility = getAgility();
        int opponentsHealth = opponent.getHealth();
        opponent.setHealth(opponentsHealth - archersAgility);
    }
}
