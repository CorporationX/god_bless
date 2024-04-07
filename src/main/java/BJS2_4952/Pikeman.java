package BJS2_4952;

public class Pikeman extends Creature {
    private static final int ATTACK = 6;
    private static final int HEALTH_POINT = 12;
    private static final int HASTE = 19;

    public Pikeman(String name, int level) {
        super(name, level, ATTACK, HEALTH_POINT + level * 2, HASTE);
    }

    @Override
    public int getDamage() {
        return this.getAttack();
    }
}
