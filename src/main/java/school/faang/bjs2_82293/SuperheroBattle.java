package school.faang.bjs2_82293;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
@RequiredArgsConstructor
public class SuperheroBattle {
    private final ExecutorService executor;

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        return pairs.stream()
                .map(pair -> executor.submit(() -> determineWinner(pair)))
                .toList();
    }

    private Superhero determineWinner(Pair<Superhero, Superhero> pair) {
        try {
            Superhero hero1 = pair.first();
            Superhero hero2 = pair.second();

            int power1 = hero1.getPower();
            int power2 = hero2.getPower();

            Superhero winner = power1 >= power2 ? hero1 : hero2;

            log.info("Battle: {} (power {}) vs {} (power {}) — Winner: {}",
                    hero1.getName(), power1, hero2.getName(), power2, winner.getName());

            return winner;
        } catch (Exception e) {
            log.error("Error in battle between {} and {}",
                    pair.first().getName(), pair.second().getName(), e);
            throw e;
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
