package faang.school.godbless.task.might.and.magic.creature;

public class Griffin extends Creature {
    private static final int GRIFFIN_HEALTH = 67;
    private static final int GRIFFIN_DAMAGE = 29;
    private static final int GRIFFIN_DEFENCE = 11;
    private static final int GRIFFIN_MOVEMENT = 6;
    private static final int GRIFFIN_QUANTITY = 0;

    public Griffin(String name, int level) {
        super(name, level, GRIFFIN_HEALTH, GRIFFIN_DAMAGE, GRIFFIN_DEFENCE,
                GRIFFIN_MOVEMENT, GRIFFIN_QUANTITY);
    }

    @Override
    public void reloadHealth() {
        this.health = GRIFFIN_HEALTH;
    }

    @Override
    public void reloadDamage() {
        this.damage = GRIFFIN_DAMAGE;
    }
}
