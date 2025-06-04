package school.faang.BJS2_79209;

public class Archer extends Character {
    private static final int INITIAL_STRENGTH = 3;
    private static final int INITIAL_AGILITY = 10;
    private static final int INITIAL_INTELLECT = 5;

    public Archer(String name) {
        super(name, INITIAL_STRENGTH, INITIAL_AGILITY, INITIAL_INTELLECT);
    }

    @Override
    public void attack(Character opponent) {
        int hitPoints = 0;
        if (isAliveAfterAttack(opponent, agility)) {
            hitPoints = opponent.health - agility;
        }

        opponent.health = hitPoints;
    }
}
