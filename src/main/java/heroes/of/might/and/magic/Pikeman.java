package heroes.of.might.and.magic;

public class Pikeman extends Creature {
    private static final String NAME = "Pikeman";
    private static final int LEVEL = 1;
    private static final int ATTACK = 10;
    private static final int DEFENCE = 5;
    private static final int SPEED = 2;

    public Pikeman() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED);
    }
}
