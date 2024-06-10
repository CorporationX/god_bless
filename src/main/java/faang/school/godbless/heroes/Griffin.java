package faang.school.godbless.heroes;

public class Griffin extends Creature {
    private static final String DEFAULT_NAME = "Griffin";
    private static final int DEFAULT_DAMAGE = 8;
    private static final int DEFAULT_DEFENCE = 8;

    public Griffin(int quantity) {
        super(DEFAULT_NAME, DEFAULT_DAMAGE, DEFAULT_DEFENCE, quantity);
    }
}
