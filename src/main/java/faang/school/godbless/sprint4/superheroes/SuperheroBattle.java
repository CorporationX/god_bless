package faang.school.godbless.sprint4.superheroes;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> competitions) {
        ExecutorService executorService = Executors.newFixedThreadPool(competitions.size());
        Future<Superhero> future = null;
        List<Future<Superhero>> winnersFutures = new ArrayList<>();
        for (int i = 0; i < competitions.size(); i++) {
            Superhero superhero = competitions.get(i).getValue();
            Superhero superhero2 = competitions.get(i).getKey();

            future = executorService.submit(() -> {
                superhero.setStrength(superhero.getStrength() - superhero2.getAgility());
                superhero2.setStrength(superhero2.getStrength() - superhero.getAgility());

                if (superhero.getStrength() > superhero2.getStrength()) {
                    return superhero;
                } else if (superhero2.getStrength() > superhero.getStrength()) {
                    return superhero2;
                } else {
                    superhero.setStrength(superhero.getStrength() - superhero2.getAgility());
                    superhero2.setStrength(superhero2.getStrength() - superhero.getAgility());

                    if (superhero.getStrength() > superhero2.getStrength()) {
                        return superhero;
                    }
                    if (superhero2.getStrength() > superhero.getStrength()) {
                        return superhero2;
                    }
                }
                return null;
            });
            winnersFutures.add(future);
        }
        executorService.shutdown();
        return winnersFutures;
    }

}
