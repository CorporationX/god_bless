package faang.school.godbless;

import lombok.Getter;

@Getter
public class Pikeman extends Creature {

    public Pikeman() {
        super("Pikeman", 1, 3, 10, 3, 10);
    }

    @Override
    public int getDamage() {
        return getAttack() * getSpeed();
    }
}
