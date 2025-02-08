package school.faang.task_56456;

public class Archer extends Character {
    private static final int BASIC_STRENGTH_VALUE = 3;
    private static final int BASIC_AGILITY_VALUE = 10;
    private static final int BASIC_INTELLIGENCE_VALUE = 5;

    public Archer(String name) {
        super(name, BASIC_STRENGTH_VALUE, BASIC_AGILITY_VALUE, BASIC_INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        opponent.checkNegativeHealth();
    }
}
