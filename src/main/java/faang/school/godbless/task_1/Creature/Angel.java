package faang.school.godbless.task_1.Creature;

public class Angel extends Creature {

    private static final String NAME = "Angel";
    private static final int LEVEL = 2;
    private static final int ATTACK = 2;
    private static final int DEFENCE = 3;
    private static final int SPEED = 2;
    private static final int HEALTH = 20;

    public Angel() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, HEALTH);
    }
}
