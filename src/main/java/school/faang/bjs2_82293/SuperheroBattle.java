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
                .map(pair -> executor.submit(() -> {
                    try {
                        Superhero hero1 = pair.first();
                        Superhero hero2 = pair.second();
                        int score1 = hero1.getStrength() + hero1.getAgility();
                        int score2 = hero2.getStrength() + hero2.getAgility();
                        return score1 >= score2 ? hero1 : hero2;
                    } catch (Exception e) {
                        log.error("Error in the competition between {} and {}",
                                pair.first().getName(), pair.second().getName(), e);
                        throw e;
                    }
                }))
                .toList();
    }

    public void shutdown() {
        executor.shutdown();
    }

}
