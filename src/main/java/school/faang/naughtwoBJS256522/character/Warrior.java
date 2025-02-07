package school.faang.naughtwoBJS256522.character;

public class Warrior extends school.faang.naughtwoBJS256522.character.Character {
    private int DEFAULT_WARRIOR_STRENGTH_VALUE = 10;
    private int DEFAULT_WARRIOR_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name);
        setStrength(DEFAULT_WARRIOR_STRENGTH_VALUE);
        setIntelligence(DEFAULT_WARRIOR_INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        super.attack(opponent);
    }
}
