package faang.school.godbless.abstraction;

public class Archer extends Character {

    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        this.strength = STRENGTH;
        this.dexterity = DEXTERITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.dexterity;
    }
}
