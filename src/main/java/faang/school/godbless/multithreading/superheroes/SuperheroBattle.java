package faang.school.godbless.multithreading.superheroes;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private final ExecutorService executorService;

    public SuperheroBattle() {
        executorService = Executors.newCachedThreadPool();
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroes) {
        return superheroes.stream()
                .map(pair -> executorService.submit(() -> getWinner(pair)))
                .toList();
    }

    private Superhero getWinner(Pair<Superhero, Superhero> pair) {
        return pair.first().getTotalPower() > pair.second().getTotalPower() ? pair.first() : pair.second();
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
