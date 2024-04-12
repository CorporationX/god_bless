package faang.school.godbless.abstractionabstraction;

public class Archer extends Character {
    private final static int DEFAULT_POWER_POINTS = 3;
    private final static int DEFAULT_DEXTERITY_POINTS = 10;
    private final static int DEFAULT_INTELLIGENCE_POINTS = 5;


    public Archer(final String name) {
        super(
                name,
                DEFAULT_POWER_POINTS,
                DEFAULT_DEXTERITY_POINTS,
                DEFAULT_INTELLIGENCE_POINTS);
    }

    @Override
    public void attack(Character character) {
        int dexterityOfAttacker;
        int currentHealthOfAttacked;

        dexterityOfAttacker = this.getDexterity();
        currentHealthOfAttacked = character.getHealth();
        character.setHealth(currentHealthOfAttacked - dexterityOfAttacker);
    }
}
