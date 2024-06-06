package faang.school.godbless.domain;

public class Warrior extends Character {

    public static final int DEFAULT_STR = 10;
    public static final int DEFAULT_AGI = 5;
    public static final int DEFAULT_INT = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STR, DEFAULT_AGI, DEFAULT_INT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getStrength());
    }
}

