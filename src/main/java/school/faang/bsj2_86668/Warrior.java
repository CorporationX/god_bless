package school.faang.bsj2_86668;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH_VALUE = 10;
    private static final int DEFAULT_AGILITY_VALUE = 5;
    private static final int DEFAULT_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH_VALUE, DEFAULT_AGILITY_VALUE, DEFAULT_INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth();
        opponent.setHealth(opponentHealth - this.strength);
    }
}
