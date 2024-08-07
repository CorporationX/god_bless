package faang.school.godbless.BJS2_19000;

public class Angel extends Creature {
    private static final String NAME = "Angel";
    private static final int LEVEL = 10;
    private static final int ATTACK = 7;
    private static final int DEFENSE = 10;
    private static final int SPEED = 8;

    public Angel(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
