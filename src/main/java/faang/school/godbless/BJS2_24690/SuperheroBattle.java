package faang.school.godbless.BJS2_24690;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@AllArgsConstructor
public class SuperheroBattle {
    private ExecutorService executor;

    public List<Future<Superhero>> runCompetitions(List<Pair> pairs) {
        return pairs.stream()
                .map(pair -> executor.submit(() -> battle(pair)))
                .toList();
    }

    public Superhero battle(Pair pair) {
        System.out.println("Battle started for " + pair);
        int power1 = pair.first().getAgility() + pair.first().getAgility();
        int power2 = pair.second().getAgility() + pair.second().getAgility();
        return power1 > power2 ? pair.first() : pair.second();
    }
}
