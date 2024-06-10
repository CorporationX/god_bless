package faang.school.godbless.heroes;

public class Swordman extends Creature {
    private static final String DEFAULT_NAME = "Swordman";
    private static final int DEFAULT_DAMAGE = 10;
    private static final int DEFAULT_DEFENCE = 12;

    public Swordman(int quantity) {
        super(DEFAULT_NAME, DEFAULT_DAMAGE, DEFAULT_DEFENCE, quantity);
    }
}
