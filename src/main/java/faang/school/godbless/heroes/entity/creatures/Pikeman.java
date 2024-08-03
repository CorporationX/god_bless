package faang.school.godbless.heroes.entity.creatures;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Pikeman extends Creature {
    private static final int BASE_LEVEL = 2;
    private static final int BASE_ATTACK = 5;
    private static final int BASE_DEFENSE = 5;
    private static final int BASE_SPEED = 4;
    private static final int BASE_QUANTITY = 0;

    public Pikeman(String name) {
        super(name, BASE_LEVEL, BASE_ATTACK, BASE_DEFENSE, BASE_SPEED, BASE_QUANTITY);
    }
}