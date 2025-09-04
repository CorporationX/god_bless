package school.faang.bsj2_86668;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH_VALUE = 3;
    private static final int DEFAULT_AGILITY_VALUE = 10;
    private static final int DEFAULT_INTELLIGENCE_VALUE = 5;

    public Archer(String name) {
        super(name);
        this.strength = DEFAULT_STRENGTH_VALUE;
        this.agility = DEFAULT_AGILITY_VALUE;
        this.intelligence = DEFAULT_INTELLIGENCE_VALUE;
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth();
        opponent.setHealth(opponentHealth - this.agility);
    }
}
