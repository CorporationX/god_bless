package faang.school.godbless.bjs2_18959.creatures;

public class Swordman extends Creature {
    private static final int DEFAULT_PRICE = 20;

    private static final int DEFAULT_POWER = 15;
    private static final int DEFAULT_DEFENCE = 2;
    private static final int DEFAULT_SPEED = 1;

    public Swordman(String name) {
        super(DEFAULT_PRICE, DEFAULT_POWER, DEFAULT_DEFENCE, DEFAULT_SPEED);
        this.name = name;
    }
}
