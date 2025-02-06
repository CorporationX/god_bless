package school.faang.abstraction;

public class Warrior extends Character {

    private static final int POWER_LEVEL = 10;
    private static final int DEXTERITY_LEVEL = 5;
    private static final int INTELLIGENCE_LEVEL = 3;

    public Warrior(String name) {
        super(name, POWER_LEVEL, DEXTERITY_LEVEL, INTELLIGENCE_LEVEL);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(POWER_LEVEL);
    }
}
