package faang.school.godbless.superheroes_battle;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SuperheroBattle {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public List<Future<Superhero>> runCompetitions(Map<Superhero, Superhero> superheroPairs) {
        List<Future<Superhero>> winnerFutureList = new ArrayList<>();
        for (Map.Entry<Superhero, Superhero> entry : superheroPairs.entrySet()) {
            Future<Superhero> winner = executorService.submit(() -> {
                Superhero firstHero = entry.getKey();
                Superhero secondHero = entry.getValue();
                if (firstHero.getStrength() + firstHero.getAgility() > secondHero.getStrength() + secondHero.getAgility()) {
                    return firstHero;
                } else {
                    return secondHero;
                }
            });
            winnerFutureList.add(winner);
        }
        return winnerFutureList;
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
    }
}
