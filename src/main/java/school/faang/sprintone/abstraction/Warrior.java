package school.faang.sprintone.abstraction;

public class Warrior extends Character {

    private static final int STRENGTH_WARRIOR_INITIAL = 10;
    private static final int AGILITY_WARRIOR_INITIAL = 5;
    private static final int INTELLIGENCE_WARRIOR_INITIAL = 3;

    public Warrior(String name) {
        super(name, STRENGTH_WARRIOR_INITIAL, AGILITY_WARRIOR_INITIAL, INTELLIGENCE_WARRIOR_INITIAL);
    }

    @Override
    void attack(Character opponent) {
        opponent.takeDamage(STRENGTH_WARRIOR_INITIAL);
        System.out.printf("%s атакует %s и наносит %d урона!%n",
                this.name, opponent.name, STRENGTH_WARRIOR_INITIAL);
    }
}
