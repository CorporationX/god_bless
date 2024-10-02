package school.faang;

public class Archer extends Character {

    private static final int BASE_STRENGTH = 3;

    private static final int BASE_AGILITY = 10;

    private static final int BASE_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}
