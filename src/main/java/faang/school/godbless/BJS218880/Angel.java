package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Angel extends Creature{

    static final String NAME = "Angel";
    static int LEVEL = 10;
    static final int ATTACK = 100;
    static final int DEFENCE = 80;
    static final int SPEED = 90;

    public Angel(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, quantity);
    }
}
