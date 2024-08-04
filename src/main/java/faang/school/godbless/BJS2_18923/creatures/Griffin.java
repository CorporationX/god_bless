package faang.school.godbless.BJS2_18923.creatures;

import faang.school.godbless.BJS2_18923.Creature;

public class Griffin extends Creature {
    public Griffin(String name) {
        super(name,6,7,3,10,4);
    }
    @Override
    public int getDamage() {
        return 0;
    }
}
