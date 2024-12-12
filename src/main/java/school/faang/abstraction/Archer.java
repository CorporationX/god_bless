package school.faang.abstraction;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    public Archer(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - character.getDexterity());
    }
}