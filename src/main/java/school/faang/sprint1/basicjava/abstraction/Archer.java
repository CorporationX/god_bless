package school.faang.sprint1.basicjava.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
        if (opponent.checkHealth()) {
            opponent.setHealth(0);
        }
    }
}
