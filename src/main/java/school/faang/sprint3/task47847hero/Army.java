package school.faang.sprint3.task47847hero;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import lombok.SneakyThrows;

public class Army {
    private List<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    @SneakyThrows
    public Integer calculateTotalPower() {
        Map<Hero, List<Integer>> mapHeroes = heroes.stream()
                .collect(Collectors.toMap(
                        hero -> hero,
                        hero -> List.of(hero.getPower())
                ));

        ExecutorService executor = Executors.newFixedThreadPool(mapHeroes.size());
        AtomicInteger totalPower = new AtomicInteger(0);
        for (Map.Entry<Hero, List<Integer>> entry : mapHeroes.entrySet()) {
            List<Integer> powers = entry.getValue();
            Hero hero = entry.getKey();
            List<Integer> powersCopy = new ArrayList<>(powers);
            Hero heroCopy = hero;

            executor.submit(() -> {
                int sum = powersCopy.stream()
                        .reduce(0, Integer::sum);
                totalPower.addAndGet(sum);
                System.out.println("Задача выполнена для типа: " + heroCopy.getClass().getSimpleName()
                        + ", суммарная сила: " + sum);
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MILLISECONDS);
        return totalPower.get();
    }
}
