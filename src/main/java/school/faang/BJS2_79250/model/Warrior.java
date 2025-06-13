package school.faang.BJS2_79250.model;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH_ATTRIBUTE_VALUE = 10;
    private static final int DEFAULT_AGILITY_ATTRIBUTE_VALUE = 5;
    private static final int DEFAULT_INTELLIGENCE_ATTRIBUTE_VALUE = 3;

    public Warrior(String name) {
        super(name,
            DEFAULT_STRENGTH_ATTRIBUTE_VALUE,
            DEFAULT_AGILITY_ATTRIBUTE_VALUE,
            DEFAULT_INTELLIGENCE_ATTRIBUTE_VALUE);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - this.getStrength());
    }
}
