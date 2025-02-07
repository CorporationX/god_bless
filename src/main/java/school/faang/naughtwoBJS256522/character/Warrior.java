package school.faang.naughtwoBJS256522.character;

public class Warrior extends Character {
    private final int defaultWarriorStrengthValue = 10;
    private final int defaultWarriorIntelligenceValue = 3;

    public Warrior(String name) {
        super(name);
        setStrength(defaultWarriorStrengthValue);
        setIntelligence(defaultWarriorIntelligenceValue);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        super.attack(opponent);
    }
}
