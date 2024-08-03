package faang.school.godbless.heroes.entity.creatures;

public class Swordman extends Creature {
        private static final int BASE_LEVEL = 3;
    private static final int BASE_DAMAGE = 6;
    private static final int BASE_DEFENSE = 8;
    private static final int BASE_SPEED = 5;
    private static final int BASE_QUANTITY = 0;

    public Swordman(String name) {
        super(name, BASE_LEVEL, BASE_DAMAGE, BASE_DEFENSE, BASE_SPEED, BASE_QUANTITY);
    }
}
