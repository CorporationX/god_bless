package faang.school.godbless.domain;

public class Archer extends Character {

    public static final int DEFAULT_STR = 3;
    public static final int DEFAULT_AGI = 10;
    public static final int DEFAULT_INT = 5;

    public Archer(String name) {
        super(name, DEFAULT_STR, DEFAULT_AGI, DEFAULT_INT);

    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getAgility());

    }
}
