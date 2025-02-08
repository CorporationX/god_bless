package school.faang.naughtwoBJS256522.character;

public class Archer extends Character {
    private static final int DEFAULT_ARCHER_STRENGTH_VALUE = 3;
    private static final int DEFAULT_ARCHER_AGILITY_VALUE = 10;
    private static final int DEFAULT_ARCHER_INTELLIGENCE_VALUE = 5;

    public Archer(String name) {
        super(name, DEFAULT_ARCHER_STRENGTH_VALUE, DEFAULT_ARCHER_AGILITY_VALUE, DEFAULT_ARCHER_INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        super.attack(opponent);
    }
}
