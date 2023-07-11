package faang.school.godbless.Sprint_5.Multithreading_Async.SuperheroesBattle;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        ExecutorService executor = Executors.newFixedThreadPool(pairs.size());
        Future<Superhero> hero = null;
        List<Future<Superhero>> winners = new ArrayList<>();
        for (Pair pair : pairs) {
            Superhero hero1 = (Superhero) pair.first;
            Superhero hero2 = (Superhero) pair.second;

            hero = executor.submit(() -> {
                if (hero1.getStrength() + hero1.getAgility() > hero2.getStrength() + hero2.getAgility()) {
                    return hero1;
                } else if (hero1.getStrength() + hero1.getAgility() < hero2.getStrength() + hero2.getAgility()) {
                    return hero2;
                } else {
                    return null;
                }
            });
            winners.add(hero);
        }
        executor.shutdown();
        return winners;
    }
}
