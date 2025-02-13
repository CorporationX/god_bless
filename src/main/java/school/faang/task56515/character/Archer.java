package school.faang.task56515.character;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int INTELLIGENCE = 5;
    private static final int DEXTERITY = 10;

    public Archer(String name) {
        super(name);
        this.setStrength(STRENGTH);
        this.setIntelligence(INTELLIGENCE);
        this.setDexterity(DEXTERITY);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(Math.max(opponent.getHealth() - dexterity, 0));
    }
}
