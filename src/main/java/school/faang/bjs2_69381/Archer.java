package school.faang.bjs2_69381;

public class Archer extends Character {
    private static final int DEFAULT_POWER = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_POWER, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(agility);
    }
}