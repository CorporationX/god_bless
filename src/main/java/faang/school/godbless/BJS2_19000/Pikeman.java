package faang.school.godbless.BJS2_19000;

public class Pikeman extends Creature {
    private static final String NAME = "Pikeman";
    private static final int LEVEL = 1;
    private static final int ATTACK = 2;
    private static final int DEFENSE = 2;
    private static final int SPEED = 3;


    public Pikeman(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
