package school.faang.sprint3.task47847hero;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Army {
    private List<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public Integer calculateTotalPower() throws InterruptedException {
        Map<Hero, List<Integer>> mapHeroes = heroes.stream()
                .collect(Collectors.toMap(
                        hero -> hero,
                        hero -> List.of(hero.getPower())
                ));

        List<Thread> threads = new ArrayList<>();
        AtomicInteger totalPower = new AtomicInteger(0);

        for (Map.Entry<Hero, List<Integer>> entry : mapHeroes.entrySet()) {
            List<Integer> powers = entry.getValue();
            Thread thread = new Thread(() -> {
                int sum = powers.stream()
                        .reduce(0, Integer::sum);
                totalPower.addAndGet(sum);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return totalPower.get();
    }
}
