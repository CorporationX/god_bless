package school.faang;

public class Archer extends Character {

    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.health -= agility;
    }
}
