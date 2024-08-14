package faang.school.godbless.bjs2_18959.creatures;

public class Angel extends Creature {
    private static final int DEFAULT_PRICE = 25;

    private static final int DEFAULT_POWER = 5;
    private static final int DEFAULT_DEFENCE = 1;
    private static final int DEFAULT_SPEED = 10;

    public Angel(String name) {
        super(DEFAULT_PRICE, DEFAULT_POWER, DEFAULT_DEFENCE, DEFAULT_SPEED);
        this.name = name;
    }
}
