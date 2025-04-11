package school.faang.abstraction;

public class Archer extends Character {

    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {

        super(ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE, name);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.getAgility());
    }
}
