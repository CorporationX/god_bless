package superheroes_battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private final ExecutorService executorService;

    public SuperheroBattle() {
        executorService = Executors.newFixedThreadPool(5);
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairList) {
        List<Future<Superhero>> winnersFuture = new ArrayList<>();
        for (Pair<Superhero, Superhero> pair : pairList) {
            Superhero firstHero = pair.getFirstHero();
            Superhero secondHero = pair.getSecondHero();
            int chancesFirst = firstHero.getStrength() + firstHero.getAgility();
            int chancesSecond = secondHero.getStrength() + secondHero.getAgility();

            Callable<Superhero> fight = () -> {
                if (chancesFirst > chancesSecond) {
                    return firstHero;
                } else if (chancesFirst < chancesSecond) {
                    return secondHero;
                } else {
                    return new Random().nextBoolean() ? firstHero : secondHero;
                }
            };

            winnersFuture.add(executorService.submit(fight));
        }

        return winnersFuture;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
