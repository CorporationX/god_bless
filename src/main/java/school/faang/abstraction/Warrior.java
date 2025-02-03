package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntellect(3);
    }

    public Warrior(String name, int willpower, int adroitness, int intellect) {
        super(name, willpower, adroitness, intellect);
    }

    @Override
    public void attack(Character opponent) {

        checkOpponentHealth(opponent, getStrength());
        opponent.setHealth(opponent.getHealth() - getStrength());
    }
}
