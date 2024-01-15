package faang.school.godbless.Superheroes_battle;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SuperheroBattle {
    public List<CompletableFuture<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        ExecutorService service = Executors.newFixedThreadPool(pairs.size());
        List<CompletableFuture<Superhero>> futures = pairs.stream()
                .map(pair -> CompletableFuture.supplyAsync(() -> fight(pair.getFirst(), pair.getSecond()), service))
                .toList();
        service.shutdown();
        return futures;
    }

    public static Superhero fight(Superhero first, Superhero second) {
        Superhero winner = null;
        if (first.getStrength() + first.getAgility() < second.getStrength() + second.getAgility()) {
            winner = second;
        } else if (first.getStrength() + first.getAgility() > second.getStrength() + second.getAgility()) {
            winner = first;
        } else {
            if (first.getStrength() > second.getStrength()) {
                winner = first;
            } else if (first.getStrength() < second.getStrength()) {
                winner = second;
            }
        }
        return winner;
    }
}
