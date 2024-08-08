package faang.school.godbless;

import lombok.Getter;

@Getter
public class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 1, 25, 15, 12, 2, 100);
    }

    @Override
    public int getDamage() {
        return getAttack() * getSpeed();
    }
}
