package faang.school.godbless.task.might.and.magic.creature;

public class Angel extends Creature {
    private static final int ANGEL_HEALTH = 30;
    private static final int ANGEL_DAMAGE = 46;
    private static final int ANGEL_DEFENCE = 10;
    private static final int ANGEL_MOVEMENT = 14;
    private static final int ANGEL_QUANTITY = 0;

    public Angel(String name, int level) {
        super(name, level, ANGEL_HEALTH, ANGEL_DAMAGE, ANGEL_DEFENCE,
                ANGEL_MOVEMENT, ANGEL_QUANTITY);
    }
}
