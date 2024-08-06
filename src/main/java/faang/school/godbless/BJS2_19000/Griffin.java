package faang.school.godbless.BJS2_19000;

public class Griffin extends Creature {
    private static final String NAME = "Griffin";
    private static final int LEVEL = 3;
    private static final int ATTACK = 4;
    private static final int DEFENSE = 4;
    private static final int SPEED = 8;

    public Griffin(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
