package school.faang.task_50587;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SuperheroBattle {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> battlePairs) {
        return battlePairs.stream()
                .map(pair -> CompletableFuture.supplyAsync(() -> {
                    Superhero winner = (pair.first.strength + pair.first.agility)
                            >= (pair.second.strength + pair.second.agility)
                            ? new Superhero(pair.first.name, pair.first.strength, pair.first.agility)
                            : new Superhero(pair.second.name, pair.second.strength, pair.second.agility);
                    return winner;
                }, executor))
                .collect(Collectors.toList());
    }

    public void shutdown() {
        executor.shutdown();
    }

}
