package faang.school.godbless.army_of_heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Hero> heroes = new ArrayList<>();

    public void addUnit(Hero hero) {
        this.heroes.add(hero);
    }

    public Integer calculateTotalPower() throws InterruptedException {
        List<PowerThread> mageThreads = new ArrayList<>();
        List<PowerThread> archerThreads = new ArrayList<>();
        List<PowerThread> swordsmanThreads = new ArrayList<>();

        for (Hero hero : heroes) {
            if (hero.isMage()) {
                startThreads(mageThreads, hero);
            } else if (hero.isArcher()) {
                startThreads(archerThreads, hero);
            } else if (hero.isSwordsMan()) {
                startThreads(swordsmanThreads, hero);
            }
        }

        return getPowerSum(mageThreads) + getPowerSum(archerThreads) + getPowerSum(swordsmanThreads);
    }

    private int getPowerSum(List<PowerThread> powerThreads) throws InterruptedException {
        int totalPower = 0;
        for (PowerThread powerThread : powerThreads) {
            powerThread.join();
            totalPower += powerThread.getPower();
        }
        return totalPower;
    }

    private void startThreads(List<PowerThread> powerThreads, Hero hero) {
        PowerThread powerThread = new PowerThread(hero);
        powerThreads.add(powerThread);
        powerThread.start();
    }
}
