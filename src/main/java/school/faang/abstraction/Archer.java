package school.faang.abstraction;

public class Archer extends Character {

    private static final int POWER_LEVEL = 3;
    private static final int DEXTERITY_LEVEL = 10;
    private static final int INTELLIGENCE_LEVEL = 5;

    public Archer(String name) {
        super(name, POWER_LEVEL, DEXTERITY_LEVEL, INTELLIGENCE_LEVEL);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(DEXTERITY_LEVEL);
    }
}
