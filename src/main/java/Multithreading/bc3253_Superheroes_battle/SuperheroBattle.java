package Multithreading.bc3253_Superheroes_battle;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superHeroesPair) {
        ExecutorService executorService = Executors.newFixedThreadPool(superHeroesPair.size());
        List<Future<Superhero>> futureList = superHeroesPair.stream()
                .map(pair -> executorService.submit(() -> {
                    if (pair.getSuperhero1().getStrength() + pair.getSuperhero1().getAgility() > pair.getSuperhero2().getStrength() + pair.getSuperhero2().getAgility()) {
                        return pair.getSuperhero1();
                    } else {
                        return pair.getSuperhero2();
                    }
                })).toList();

        executorService.shutdown();

        return futureList;
    }
}
