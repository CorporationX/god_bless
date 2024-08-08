package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Griffin extends Creature {

    static final String NAME = "Griffin";
    static int LEVEL = 5;
    static final int ATTACK = 35;
    static final int DEFENCE = 30;
    static final int SPEED = 30;

    public Griffin(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, quantity);
    }
}
