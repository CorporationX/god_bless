package faang.school.godbless.abstraction;

public class Warrior extends Character {
    private static final int FORCE = 10;
    private static final int AGILITY = 5;
    private static final int INTELLECT = 3;

    public Warrior(String name) {
        super(name, FORCE, AGILITY, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.takeDamage(FORCE);
    }
}
