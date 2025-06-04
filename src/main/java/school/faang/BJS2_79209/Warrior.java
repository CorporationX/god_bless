package school.faang.BJS2_79209;

public class Warrior extends Character {
    private static final int INITIAL_STRENGTH = 10;
    private static final int INITIAL_AGILITY = 5;
    private static final int INITIAL_INTELLECT = 3;

    public Warrior(String name) {
        super(name, INITIAL_STRENGTH, INITIAL_AGILITY, INITIAL_INTELLECT);
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
