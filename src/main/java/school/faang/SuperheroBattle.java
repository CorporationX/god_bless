package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class SuperheroBattle {
    private static final double FIFTY_PERCENT_WIN = 0.5;
    private static final int BATTLE_DURATION_MS = 2000;

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> heroes,
                                                   ExecutorService executor) {
        return heroes.stream()
                .map(pair -> executor.submit(() ->
                        compete(pair.getFirst(), pair.getSecond())))
                .toList();
    }

    private Superhero compete(Superhero hero1, Superhero hero2) {
        try {
            Thread.sleep(BATTLE_DURATION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sleep interrupted in \"compete\".");
        }
        if (hero1.getPower() > hero2.getPower()) {
            return hero1;
        } else if (hero1.getPower() < hero2.getPower()) {
            return hero2;
        }
        return (Math.random() >= FIFTY_PERCENT_WIN) ? hero1 : hero2;
    }
}
