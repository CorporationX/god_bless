package sprint5.superhero;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroes) {
        ExecutorService service = Executors.newFixedThreadPool(superheroes.size());

        List<Future<Superhero>> winners = superheroes.stream()
                .map(pair ->
                        CompletableFuture.supplyAsync(fight(pair), service))
                .collect(Collectors.toList());
        service.shutdown();
        return winners;
    }

    private Supplier<Superhero> fight(Pair<Superhero, Superhero> pair) {
        return () -> {
            int totalPowerOfFirstHero = pair.first().agility() + pair.first().strength();
            int totalPowerOfSecondHero = pair.second().agility() + pair.second().strength();
            if (totalPowerOfFirstHero > totalPowerOfSecondHero) {
                return pair.first();
            } else {
                return pair.second();
            }
        };
    }
}
