package faang.school.godbless.BJS2_19000;

public class Swordman extends Creature {
    private static final String NAME = "Swordman";
    private static final int LEVEL = 5;
    private static final int ATTACK = 6;
    private static final int DEFENSE = 6;
    private static final int SPEED = 5;

    public Swordman(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
