package faang.school.godbless.parallelism.heroes_might_and_magic;

import faang.school.godbless.parallelism.heroes_might_and_magic.entity.Unit;

public class PowerThread extends Thread {
    private Unit unit;
    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }

    public int getPower() {
        return power;
    }
}
