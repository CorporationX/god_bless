package heroes.of.might.and.magic;

public class Griffin extends Creature {
    private static final String NAME = "Griffin";
    private static final int LEVEL = 5;
    private static final int ATTACK = 50;
    private static final int DEFENCE = 30;
    private static final int SPEED = 15;

    public Griffin() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED);
    }
}
