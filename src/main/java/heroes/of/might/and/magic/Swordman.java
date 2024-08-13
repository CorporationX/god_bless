package heroes.of.might.and.magic;

public class Swordman extends Creature {
    private static final String NAME = "Swordman";
    private static final int LEVEL = 2;
    private static final int ATTACK = 15;
    private static final int DEFENCE = 10;
    private static final int SPEED = 5;

    public Swordman() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED);
    }
}
