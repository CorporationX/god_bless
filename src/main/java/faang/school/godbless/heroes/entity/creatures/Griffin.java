package faang.school.godbless.heroes.entity.creatures;

public class Griffin extends Creature {
    private static final int BASE_LEVEL = 5;
    private static final int BASE_DAMAGE = 8;
    private static final int BASE_DEFENSE = 3;
    private static final int BASE_SPEED = 10;
    private static final int BASE_QUANTITY = 0;

    public Griffin(String name) {
        super(name, BASE_LEVEL, BASE_DAMAGE, BASE_DEFENSE, BASE_SPEED, BASE_QUANTITY);
    }
}
