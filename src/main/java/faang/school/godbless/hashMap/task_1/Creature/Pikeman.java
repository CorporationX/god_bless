package faang.school.godbless.hashMap.task_1.Creature;

public class Pikeman extends Creature {
    private static final String NAME = "Pikeman";
    private static final int LEVEL = 2;
    private static final int ATTACK = 3;
    private static final int DEFENCE = 1;
    private static final int SPEED = 2;
    private static final int HEALTH = 10;

    public Pikeman() {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, HEALTH);
    }
}
