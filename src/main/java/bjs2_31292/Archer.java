package bjs2_31292;

public class Archer extends Character {
    public static final Integer ARCHER_POWER = 3;
    public static final Integer ARCHER_AGILITY = 10;
    public static final Integer ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getAgility());
    }
}
