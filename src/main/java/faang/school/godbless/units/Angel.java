package faang.school.godbless.units;

public class Angel extends Creature {

    private static final int LEVEL = 7;
    private static final int ATTACK = 20;
    private static final int DEFENSE = 20;
    private static final int SPEED = 12;
    private static final int DAMAGE = 50;
    private static final String NAME = "Angel";

    public Angel() {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED);
    }

    @Override
    public int getDamage() {
        return DAMAGE * this.getAttack() * this.getQuantity();
    }
}
