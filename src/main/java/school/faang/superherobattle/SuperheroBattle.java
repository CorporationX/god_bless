package school.faang.superherobattle;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SuperheroBattle {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    private static final double PROBABILITY_HERO_1_WINS = 0.5;

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superHeroPairs) {
        return superHeroPairs.stream()
                .map(pair -> executor.submit(() -> {
                    Superhero hero1 = pair.getKey();
                    Superhero hero2 = pair.getValue();
                    return compete(hero1, hero2);
                }))
                .toList();
    }

    private Superhero compete(Superhero hero1, Superhero hero2) {
        if (hero1.getPower() > hero2.getPower()) {
            return hero1;
        } else if (hero2.getPower() > hero1.getPower()) {
            return hero2;
        } else {
            return Math.random() > PROBABILITY_HERO_1_WINS ? hero1 : hero2;
        }
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Задача не завершилась в течении 5 секунд, завершаю работу.");
            }
                {
                executor.shutdownNow();
                }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static List<Superhero> getWinners(List<Future<Superhero>> winnersFutures) {
        List<Superhero> winners = new ArrayList<>();
        try {
            for (Future<Superhero> future : winnersFutures) {
                Superhero winner = future.get();
                log.info("Победитель: " + winner.name());
                winners.add(winner);
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Произошла ошибка при определении победителей", e);
            Thread.currentThread().interrupt();
        }
        return winners;
    }

    public static List<Pair<Superhero, Superhero>> createPairs(List<Superhero> winners) {
        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();
        for (int i = 0; i < winners.size(); i += 2) {
            if (i + 1 < winners.size()) {
                pairs.add(new Pair<>(winners.get(i), winners.get(i + 1)));
            }
        }
        return pairs;
    }

}

