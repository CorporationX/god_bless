package faang.school.godbless.abstraction;

public class Warrior extends Character {

    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        this.strength = STRENGTH;
        this.dexterity = DEXTERITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
