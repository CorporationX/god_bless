package faang.school.godbless.abstraction;

public class Archer extends Character {
    private static final int FORCE = 3;
    private static final int AGILITY = 10;
    private static final int INTELLECT = 5;

    public Archer(String name) {
        super(name, FORCE, AGILITY, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.takeDamage(AGILITY);
    }
}
