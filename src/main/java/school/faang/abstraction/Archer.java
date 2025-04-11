package school.faang.abstraction;

public class Archer extends Character {

    private static final int STRENGTH_ARCHER_INITIAL = 3;
    private static final int AGILITY_ARCHER_INITIAL = 10;
    private static final int INTELLIGENCE_ARCHER_INITIAL = 5;

    public Archer(String name) {
        super(name, STRENGTH_ARCHER_INITIAL, AGILITY_ARCHER_INITIAL, INTELLIGENCE_ARCHER_INITIAL);
    }

    @Override
    void attack(Character opponent) {
        opponent.takeDamage(AGILITY_ARCHER_INITIAL);
        System.out.printf("%s стреляет в %s и наносит %d урона!%n",
                this.name, opponent.name, AGILITY_ARCHER_INITIAL);
    }
}
