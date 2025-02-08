package school.faang.naughtwoBJS256522.character;

public class Warrior extends Character {
    private static final int DEFAULT_WARRIOR_STRENGTH_VALUE = 10;
    private static final int DEFAULT_WARRIOR_AGILITY_VALUE = 5;
    private static final int DEFAULT_WARRIOR_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_WARRIOR_STRENGTH_VALUE, DEFAULT_WARRIOR_AGILITY_VALUE, DEFAULT_WARRIOR_INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        super.attack(opponent);
    }
}
