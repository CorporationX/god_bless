package school.faang.sprint_3;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Army {
    private final List<Hero> heroes = new ArrayList<>();
    private int totalPower;

    public int calculateTotalPower() {
        if (heroes.isEmpty()) {
            return 0;
        }
        int chunkSize = 5;
        CountDownLatch counter = new CountDownLatch((heroes.size() + chunkSize - 1) / chunkSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < heroes.size(); i += chunkSize) {
            var finalI = i;
            executorService.submit(() -> {
                var powerOfPartHeroes = heroes.subList(finalI, Math.min(heroes.size(), finalI + chunkSize))
                        .stream()
                        .mapToInt(Hero::getPower)
                        .sum();
                addTotalPower(powerOfPartHeroes);
                counter.countDown();
            });
        }


        try {
            counter.await();
        } catch (InterruptedException e) {
            log.error("Error when counted await", e);
        }
        executorService.shutdown();

        return totalPower;
    }

    private synchronized void addTotalPower(int value) {
        totalPower += value;
    }

    public void addHero(@NonNull Hero hero) {
        heroes.add(hero);
    }
}
