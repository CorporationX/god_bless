package faang.school.godbless.heroes.entity.creatures;

public class Angel extends Creature {
    private static final int BASE_LEVEL = 10;
    private static final int BASE_DAMAGE = 15;
    private static final int BASE_DEFENSE = 10;
    private static final int BASE_SPEED = 7;
    private static final int BASE_QUANTITY = 0;

    public Angel(String name) {
        super(name, BASE_LEVEL, BASE_DAMAGE, BASE_DEFENSE, BASE_SPEED, BASE_QUANTITY);
    }
}
