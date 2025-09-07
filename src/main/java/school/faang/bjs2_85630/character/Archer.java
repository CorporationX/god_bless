package school.faang.bjs2_85630.character;

public class Archer extends Character {
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    public void attack(Character opponent) {
        checkPossibilityOfBattle(this, opponent);
        System.out.printf("%s (archer) is shooting at %s (%s)",
                getName(), opponent.getName(), opponent.getClass().getSimpleName());
        System.out.println();
        opponent.decreaseHealth(getAgility());
    }
}
