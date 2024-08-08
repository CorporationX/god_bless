package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Swordman extends Creature{

    static final String NAME = "Swordman";
    static int LEVEL = 2;
    static final int ATTACK = 25;
    static final int DEFENCE = 20;
    static final int SPEED = 18;

    public Swordman(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENCE, SPEED, quantity);
    }
}
