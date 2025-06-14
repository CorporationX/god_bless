package school.faang.bjs279266;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_DEXTERITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}