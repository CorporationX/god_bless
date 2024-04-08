package BJS2_4952;

public class Swordman extends Creature {
    private static final int ATTACK = 20;
    private static final int HEALTH_POINT = 3;
    private static final int HASTE = 7;

    public Swordman(String name, int level) {
        super(name, level, ATTACK, HEALTH_POINT + level * 2, HASTE);
    }

    @Override
    public int getDamage() {
        return this.getAttack() + HASTE;
    }
}
