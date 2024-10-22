package distributedArmyOfHeroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public int calculateTotalPower(){
        AtomicInteger totalPower = new AtomicInteger();
        List<HeroPowerCalculator> threads = new ArrayList<>();

        heroes.forEach(hero -> {
            HeroPowerCalculator thread = new HeroPowerCalculator(hero);
            threads.add(thread);
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            totalPower.addAndGet(thread.getTotalPower());
        });

        return totalPower.get();
    }
}
