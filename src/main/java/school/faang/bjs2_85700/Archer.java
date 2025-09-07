package school.faang.bjs2_85700;

public class Archer extends Character {

    private static final int ARCHER_DEFAULT_STRENGTH = 3;
    private static final int ARCHER_DEFAULT_AGILITY = 10;
    private static final int ARCHER_DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_DEFAULT_STRENGTH, ARCHER_DEFAULT_AGILITY, ARCHER_DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent != null) {
            opponent.takeDamage(getAgility());
        }
    }
}
