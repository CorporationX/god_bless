package BJS2_4952;

public class Griffin extends Creature {
    private static final int ATTACK = 14;
    private static final int HEALTH_POINT = 8;
    private static final int HASTE = 9;

    public Griffin(String name, int level) {
        super(name, level, ATTACK, HEALTH_POINT + level * 2, HASTE);
    }

    @Override
    public int getDamage() {
        return this.getAttack();
    }
}
