package faang.school.godbless.superheroesBattle;


import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairOfHeroes) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future<Superhero>> winners = new ArrayList<>();
        for (Pair<Superhero, Superhero> pairOfHero : pairOfHeroes) {
            Superhero superheroFirst = pairOfHero.first;
            Superhero superheroSecond = pairOfHero.second;

            Future<Superhero> future = executor.submit(() -> {
                superheroFirst.setStrength(superheroFirst.getStrength() + superheroFirst.getAgility());
                superheroSecond.setStrength(superheroSecond.getStrength() + superheroSecond.getAgility());

                if (superheroFirst.getStrength() > superheroSecond.getStrength()) {
                    return superheroFirst;
                } else {
                    return superheroSecond;
                }
            });
            winners.add(future);
        }
        executor.shutdown();
        return winners;
    }
}
