package faang.school.godbless.spring_4.superheroes_battle;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SuperheroBattle {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public List<Future<Superhero>> runCompetitions(List<Pair> pairs) {

        List<Future<Superhero>> futures = pairs.stream().map(pair -> CompletableFuture.supplyAsync(() -> winSuperhero(pair), pool))
                .collect(Collectors.toList());

        pool.shutdown();

        return futures;
    }

    private Superhero winSuperhero(Pair pair) {
        return pair.getHero1().getStrength() > pair.getHero2().getStrength() ? pair.getHero1() : pair.getHero2();
    }
}
