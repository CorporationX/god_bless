package faang.school.godbless.BJS2_18923.creatures;

import faang.school.godbless.BJS2_18923.Creature;

public class Pikeman extends Creature {
    public Pikeman(String name) {
        super(name, 7,8,5,5,8);
    }
    @Override
    public int getDamage() {
        return 0;
    }
}
