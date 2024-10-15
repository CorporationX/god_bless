package school.faang.BJS2_35883_HeroesArmy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Hero> heroes;

    public Army() {
        heroes = new ArrayList<>();
    }

    public void addUnit(Hero hero) {
        heroes.add(hero);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> startedThreads = new ArrayList<>();

        heroes.forEach(hero -> {
            Thread threadForHero = new Thread(new HeroPowerCalculator(hero, totalPower));
            startedThreads.add(threadForHero);
            threadForHero.start();
        });

        startedThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        return totalPower.get();
    }
}
