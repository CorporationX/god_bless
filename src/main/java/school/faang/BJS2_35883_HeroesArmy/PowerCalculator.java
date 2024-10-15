package school.faang.BJS2_35883_HeroesArmy;

import java.util.concurrent.atomic.AtomicInteger;

public class PowerCalculator implements Runnable {
    private Hero hero;
    private AtomicInteger totalPower;

    public PowerCalculator(Hero hero, AtomicInteger totalPower) {
        this.hero = hero;
        this.totalPower = totalPower;
    }

    @Override
    public void run() {
        totalPower.addAndGet(hero.getPower());
    }
}
