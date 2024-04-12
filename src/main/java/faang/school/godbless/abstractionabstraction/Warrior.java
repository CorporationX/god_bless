package faang.school.godbless.abstractionabstraction;

public class Warrior extends Character {
    private final static int DEFAULT_POWER_POINTS = 10;
    private final static int DEFAULT_DEXTERITY_POINTS = 5;
    private final static int DEFAULT_INTELLIGENCE_POINTS = 3;

    public Warrior(String name) {
        super(
                name,
                DEFAULT_POWER_POINTS,
                DEFAULT_DEXTERITY_POINTS,
                DEFAULT_INTELLIGENCE_POINTS);
    }

    @Override
    public void attack(Character character) {
        int powerOfAttacker;
        int currentHealthOfAttacked;

        powerOfAttacker = this.getPower();
        currentHealthOfAttacked = character.getHealth();
        character.setHealth(currentHealthOfAttacked - powerOfAttacker);
    }
}
