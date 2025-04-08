package school.faang.abstraction;

public class Warrior extends Character {
    private static final int STRENGTH_VALUE = 10;
    private static final int AGILITY_VALUE = 3;
    private static final int INTELLIGENCE_VALUE = 5;

    public Warrior(String name) {
        super(name, STRENGTH_VALUE, AGILITY_VALUE, INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.applyDamage(this.getStrength());
    }
}
