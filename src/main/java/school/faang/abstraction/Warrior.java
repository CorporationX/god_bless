package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {

        checkOpponentHealth(opponent, getStrength());
        opponent.setHealth(opponent.getHealth() - getStrength());
    }
}
