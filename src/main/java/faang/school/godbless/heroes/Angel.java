package faang.school.godbless.heroes;

public class Angel extends Creature {
    private static final String DEFAULT_NAME = "Angel";
    private static final int DEFAULT_DAMAGE = 20;
    private static final int DEFAULT_DEFENCE = 20;

    public Angel(int quantity) {
        super(DEFAULT_NAME, DEFAULT_DAMAGE, DEFAULT_DEFENCE, quantity);
    }
}
