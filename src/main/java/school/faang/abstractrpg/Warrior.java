package school.faang.abstractrpg;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("Warrior %s attack %s for %d damage!\n", getName(), opponent.getName(), getStrength());
        reduceHealth(getStrength());
    }
}
