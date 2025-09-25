package school.faang.bjs2_92726;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class SuperheroBattle {
    private final ExecutorService executor;

    public SuperheroBattle(int poulCount) {
        executor = Executors.newFixedThreadPool(poulCount);
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        return pairs.stream()
                .map(pair -> executor.submit(() -> {
                    int score1 = pair.first.getAgility() + pair.first.getStrength();
                    int score2 = pair.second.getAgility() + pair.second.getStrength();
                    return score1 > score2 ? pair.first :
                            score1 < score2 ? pair.second :
                                    ThreadLocalRandom.current().nextBoolean() ? pair.first : pair.second;
                }))
                .collect(Collectors.toList());
    }

    public void shutdown() {
        executor.shutdown();
    }
}
