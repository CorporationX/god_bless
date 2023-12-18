package faang.school.godbless.task_1.Creature;

public class Swordman extends Creature {

    private static final String NAME = "Swordman";
    private static final int LEVEL = 3;
    private static final int ATTACK = 3;
    private static final int DEFENCE = 3;
    private static final int SPEED = 2;
    private static final int HEALTH = 15;

    public Swordman() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, HEALTH);
    }
}
