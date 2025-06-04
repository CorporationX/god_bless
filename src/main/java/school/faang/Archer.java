package school.faang;

public class Archer extends Character {


    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    protected Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.health < ARCHER_AGILITY) {
            System.out.println(name + " win round ");
            opponent.isDeath();
        } else {
            opponent.health -= ARCHER_AGILITY;
        }
    }
}