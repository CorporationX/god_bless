package faang.school.godbless.dolbahlop;

public class Angel extends Creature {
    private static final String NAME = "Angel";
    private static final int LEVEL = 30;
    private static final int ATTACK = 100;
    private static final int DEFENSE = 120;
    private static final int SPEED = 5;

    public Angel(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }
}