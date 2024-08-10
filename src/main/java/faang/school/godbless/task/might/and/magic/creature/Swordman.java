package faang.school.godbless.task.might.and.magic.creature;

public class Swordman extends Creature {
    private static final int SWORDMAN_HEALTH = 43;
    private static final int SWORDMAN_DAMAGE = 25;
    private static final int SWORDMAN_DEFENCE = 25;
    private static final int SWORDMAN_MOVEMENT = 7;
    private static final int SWORDMAN_QUANTITY = 0;

    public Swordman(String name, int level) {
        super(name, level, SWORDMAN_HEALTH, SWORDMAN_DAMAGE, SWORDMAN_DEFENCE,
                SWORDMAN_MOVEMENT, SWORDMAN_QUANTITY);
    }

    @Override
    public void reloadHealth() {
        this.health = SWORDMAN_HEALTH;
    }

    @Override
    public void reloadDamage() {
        this.damage = SWORDMAN_DAMAGE;
    }
}
