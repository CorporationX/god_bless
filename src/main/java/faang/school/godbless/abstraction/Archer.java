package faang.school.godbless.abstraction;

public class Archer extends Character {
    private static final Integer DEFAULT_STR = 3;
    private static final Integer DEFAULT_DEX = 8;
    private static final Integer DEFAULT_INT = 5;

    public Archer(String name) {
        super(name, DEFAULT_STR, DEFAULT_DEX, DEFAULT_INT);
    }

    @Override
    public void attack(Character attackedChar) {
        attackedChar.health -= dexterity;
    }
}
