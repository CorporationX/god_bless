package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntellect(5);
    }

    public Archer(String name, int willpower, int adroitness, int intellect) {
        super(name, willpower, adroitness, intellect);
    }

    @Override
    public void attack(Character opponent) {

        checkOpponentHealth(opponent, getAgility());
        opponent.setHealth(opponent.getHealth() - getAgility());
    }
}
