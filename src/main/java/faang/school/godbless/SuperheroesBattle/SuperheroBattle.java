package faang.school.godbless.SuperheroesBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairList) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Superhero>> winners = new ArrayList<>();


        for (Pair<Superhero, Superhero> pair : pairList) {
            boolean victoryCondition = pair.first.getAgility() + pair.first.getStrength() > pair.second.getAgility() + pair.second.getStrength();
            Future<Superhero> winner = executor.submit(() -> {
                        if (victoryCondition) {
                            return pair.first;
                        }
                        return pair.second;
                    }
            );
            winners.add(winner);
        }
        return winners;
    }
}
