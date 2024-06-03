package faang.school.godbless.abstraction;

public class Warrior extends Character {
    private static final Integer DEFAULT_STR = 10;
    private static final Integer DEFAULT_DEX = 5;
    private static final Integer DEFAULT_INT = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STR, DEFAULT_DEX, DEFAULT_INT);
    }

    @Override
    public void attack(Character attackedChar) {
        attackedChar.health -= strength;
    }
}
