package school.faang.abstraction;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLECT = 3;

    public Warrior(String name) {

        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLECT);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.strength;
        checkHealth(opponent);
    }
}
