package school.faang.BJS2_35883_HeroesArmy;

import java.util.concurrent.atomic.AtomicInteger;

public class HeroPowerCalculator implements Runnable {
    private Hero hero;
    private AtomicInteger totalPower;

    public HeroPowerCalculator(Hero hero, AtomicInteger totalPower) {
        this.hero = hero;
        this.totalPower = totalPower;
    }

    @Override
    public void run() {
        totalPower.addAndGet(hero.getPower());
    }
}
