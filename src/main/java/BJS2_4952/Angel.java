package BJS2_4952;

public class Angel extends Creature {
    private static final int ATTACK = 4;
    private static final int HEALTH_POINT = 10;
    private static final int HASTE = 5;

    public Angel(String name, int level) {
        super(name, level, ATTACK, HEALTH_POINT + level * 2, HASTE);
    }

    @Override
    public int getDamage() {
        return this.getAttack() + HASTE;
    }
}
