package school.faang.BJS2_79209;

public class Warrior extends Character {
    private static final int initialStrength = 10;
    private static final int initialAgility = 5;
    private static final int initialIntellect = 3;

    public Warrior(String name) {
        super(name, initialStrength, initialAgility, initialIntellect);
    }

    @Override
    public void attack(Character opponent) {
        int hitPoints = 0;
        if (isAliveAfterAttack(opponent, strength)) {
            hitPoints = opponent.health - strength;
        }

        opponent.health = hitPoints;
    }
}
