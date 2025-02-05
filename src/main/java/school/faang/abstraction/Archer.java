package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        checkOpponentHealth(opponent, getAgility());
        opponent.setHealth(opponent.getHealth() - getAgility());
    }
}
