package school.faang.task56515.character;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int INTELLIGENCE = 3;
    private static final int DEXTERITY = 5;

    public Warrior(String name) {
        super(name);
        this.setStrength(STRENGTH);
        this.setIntelligence(INTELLIGENCE);
        this.setDexterity(DEXTERITY);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(Math.max(opponent.getHealth() - strength, 0));
    }
}
