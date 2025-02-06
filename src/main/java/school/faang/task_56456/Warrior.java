package school.faang.task_56456;

public class Warrior extends Character {
    private static final int BASIC_STRENGTH_VALUE = 10;
    private static final int BASIC_AGILITY_VALUE = 5;
    private static final int BASIC_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name, BASIC_STRENGTH_VALUE, BASIC_AGILITY_VALUE, BASIC_INTELLIGENCE_VALUE);
    }

    @Override
    void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        opponent.checkNegativeHealth();
    }
}
