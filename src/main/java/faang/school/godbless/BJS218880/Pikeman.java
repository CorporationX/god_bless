package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pikeman extends Creature{

    static final String NAME = "Pikeman";
    static int LEVEL = 1;
    static final int ATTACK = 20;
    static final int DEFENCE = 10;
    static final int SPEED = 15;

    public Pikeman(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, quantity);
    }
}
