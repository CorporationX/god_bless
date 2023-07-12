package faang.school.godbless.superHeroBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superHeroesPairs) {
        List<Future<Superhero>> result = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (var pair : superHeroesPairs) {
            Future<Superhero> winner = executor.submit(() -> battle(pair.getFirst(), pair.getSecond()));
            result.add(winner);
        }
        executor.shutdown();
        return result;
    }

    private Superhero battle(Superhero first, Superhero second) {
        while (first.getHealth() > 0 && second.getHealth() > 0) {
            int damageForFirst = second.getAgility() * second.getStrength();
            first.setHealth(first.getHealth() - damageForFirst);
            int damageForSecond = first.getAgility() * first.getStrength();
            second.setHealth(second.getHealth() - damageForSecond);
        }
        return first.getHealth() > 0 ? first : second;
    }
}
