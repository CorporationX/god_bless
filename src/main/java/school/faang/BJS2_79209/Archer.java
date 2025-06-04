package school.faang.BJS2_79209;

public class Archer extends Character {
    private static final int initialStrength = 3;
    private static final int initialAgility = 10;
    private static final int initialIntellect = 5;

    public Archer(String name) {
        super(name, initialStrength, initialAgility, initialIntellect);
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
