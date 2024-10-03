package abstractionAbstraction;

public class Archer extends Character {
    public static final int ARCHER_STRENGTH = 3;
    public static final int ARCHER_AGILITY = 10;
    public static final int ARCHER_INTELLIGENCE = 5;

    @Override
    public void attack(Character character) {
        character.decreaseHealth(ARCHER_AGILITY);
    }

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }
}
