package school.faang.javacore.abstraction;

public class Archer extends Character {
    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}