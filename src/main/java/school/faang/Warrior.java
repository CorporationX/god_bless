package school.faang;

public class Warrior extends Character {

    private static final int BASE_STRENGTH = 10;
    private static final int BASE_AGILITY = 5;
    private static final int BASE_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.strength);
    }
}
