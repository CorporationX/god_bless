package faang.school.godbless.task.hashmap.might.and.magic.creature;

public class Pikeman extends Creature {
    private static final int PIKEMAN_HEALTH = 43;
    private static final int PIKEMAN_DAMAGE = 30;
    private static final int PIKEMAN_DEFENCE = 25;
    private static final int PIKEMAN_MOVEMENT = 7;
    private static final int PIKEMAN_QUANTITY = 0;

    public Pikeman(String name, int level) {
        super(name, level, PIKEMAN_HEALTH, PIKEMAN_DAMAGE, PIKEMAN_DEFENCE,
                PIKEMAN_MOVEMENT, PIKEMAN_QUANTITY);
    }

    @Override
    public void reloadHealth() {
        this.health = PIKEMAN_HEALTH;
    }

    @Override
    public void reloadDamage() {
        this.damage = PIKEMAN_DAMAGE;
    }
}
