package faang.school.godbless.heroes;

public class Pikeman extends Creature {
    private static final String DEFAULT_NAME = "Pikeman";
    private static final int DEFAULT_DAMAGE = 4;
    private static final int DEFAULT_DEFENCE = 5;

    public Pikeman(int quantity) {
        super(DEFAULT_NAME, DEFAULT_DAMAGE, DEFAULT_DEFENCE, quantity);
    }
}
