package heroes.of.might.and.magic;

public class Angel extends Creature {
    private static final String NAME = "Angel";
    private static final int LEVEL = 10;
    private static final int ATTACK = 100;
    private static final int DEFENCE = 50;
    private static final int SPEED = 80;

    public Angel() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED);
    }
}
