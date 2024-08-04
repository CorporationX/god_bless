package faang.school.godbless.BJS2_18923.creatures;

import faang.school.godbless.BJS2_18923.Creature;

public class Swordman extends Creature {
    public Swordman(String name) {
        super(name,9,9,9,2,5);
    }
    @Override
    public int getDamage() {
        return 0;
    }
}
