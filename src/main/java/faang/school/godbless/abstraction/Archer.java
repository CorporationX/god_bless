package faang.school.godbless.abstraction;

public class Archer extends Character {

    private String name;
    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(STRENGTH, DEXTERITY, INTELLIGENCE);
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        if (character.health <= 0) {
            character.health = 0;
            throw new RuntimeException(character.name + " is dead");
        } else {
            character.health -= this.dexterity;
        }
    }
}
