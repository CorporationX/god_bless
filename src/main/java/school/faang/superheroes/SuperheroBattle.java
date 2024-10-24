package school.faang.superheroes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class SuperheroBattle {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int TIME_TO_WORK = 1000;

    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        List<Future<Superhero>> winners = new ArrayList<>();
        for (Pair<Superhero, Superhero> pair : pairs) {
            winners.add(executor.submit(() -> {
                Thread.sleep(TIME_TO_WORK);
                if (pair.getL() == null) {
                    log.info(String.format("Прошел без боя в следующий этап %s", pair.getR().getName()));
                    return pair.getR();
                }
                if (pair.getR() == null) {
                    log.info(String.format("Прошел без боя в следующий этап %s", pair.getL().getName()));
                    return pair.getL();
                }
                Superhero firstHeroes = pair.getL();
                Superhero secondHeroes = pair.getR();
                int powerAttackFirst = firstHeroes.getAgility() + firstHeroes.getStrength();
                int powerAttackSecond = secondHeroes.getAgility() + secondHeroes.getStrength();
                log.info(String.format("Бои между %s (%d) и %s (%d)",
                        firstHeroes.getName(), powerAttackFirst, secondHeroes.getName(), powerAttackSecond));
                return powerAttackFirst > powerAttackSecond ? pair.getL() : pair.getR();
            }));
        }

        if (winners.size() > 1) {
            List<Superhero> heroes = winners.stream()
                    .map(winner -> {
                        try {
                            return winner.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();
            List<Pair<Superhero, Superhero>> superheroPairs = toPairs(heroes);
            log.info("--------Следующий этап боев---------");
            winners = runCompetitions(superheroPairs);
        }

        return winners;
    }

    public List<Pair<Superhero, Superhero>> toPairs(List<Superhero> superheroes) {
        List<Pair<Superhero, Superhero>> superheroPairs = new ArrayList<>();
        for (int i = 0; i < superheroes.size(); i += 2) {
            Superhero winner = superheroes.get(i);
            Superhero winner2 = superheroes.size() > (i + 1) ? superheroes.get(i + 1) : null;
            superheroPairs.add(new Pair<>(winner, winner2));
        }
        return superheroPairs;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
