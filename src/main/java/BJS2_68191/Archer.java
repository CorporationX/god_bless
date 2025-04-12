package BJS2_68191;

public abstract class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;
    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public void attak(Character opponent) {
    }

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    public void attack(Character target) {
        target.takeDamage(DEFAULT_AGILITY);
    }
}

