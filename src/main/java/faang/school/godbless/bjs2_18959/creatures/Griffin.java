package faang.school.godbless.bjs2_18959.creatures;

public class Griffin extends Creature {
    private static final int DEFAULT_PRICE = 10;

    private static final int DEFAULT_POWER = 10;
    private static final int DEFAULT_DEFENCE = 4;
    private static final int DEFAULT_SPEED = 2;

    public Griffin(String name) {
        super(DEFAULT_PRICE, DEFAULT_POWER, DEFAULT_DEFENCE, DEFAULT_SPEED);
        this.name = name;
    }
}
