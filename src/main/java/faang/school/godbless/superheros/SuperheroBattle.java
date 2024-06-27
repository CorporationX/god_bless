package faang.school.godbless.superheros;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Getter
public class SuperheroBattle {
    private static final int FIRST_MET_CANDIDATE = 0;
    private static final int MIN_NUM_OF_FIGHTERS_REMAINING = 2;
    public static final ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroBattleList) {
        List<Future<Superhero>> superheroWinners = new ArrayList<>();

        superheroBattleList.forEach(pair -> {
            Future<Superhero> fightWinner = executorService.submit(() -> {
                Superhero firstSuperhero = pair.getFirstElement();
                Superhero secondSuperhero = pair.getSecondElement();
                log.info(firstSuperhero.getName() + " and " + secondSuperhero.getName() + " are fighting");

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return fight(pair.getFirstElement(), pair.getSecondElement());
            });
            superheroWinners.add(fightWinner);
        });

        return superheroWinners;
    }

    public List<Pair<Superhero, Superhero>> constructPairs(List<Superhero> superheroList) {
        List<Pair<Superhero, Superhero>> superheroPairList = new ArrayList<>();

        while (superheroList.size() >= MIN_NUM_OF_FIGHTERS_REMAINING) {
            Superhero firstFighter = superheroList.remove(FIRST_MET_CANDIDATE);
            Superhero secondFighter = superheroList.remove(FIRST_MET_CANDIDATE);

            Pair<Superhero, Superhero> superheroSuperheroPair = new Pair<>(firstFighter, secondFighter);

            superheroPairList.add(superheroSuperheroPair);
        }

        return superheroPairList;
    }


    public void processSurvivedSuperheros(List<Future<Superhero>> winnersFutureList,
                                          List<Superhero> superherosContinuingBattle) {
        for (int i = 0; i < winnersFutureList.size(); i++) {
            try {
                Superhero winner = winnersFutureList.get(i).get();
                log.info("Победитель битвы " + (i + 1) + ": " + winner.getName());
                superherosContinuingBattle.add(winner);
            } catch (InterruptedException e) {
                log.warn("Fighting was interrupted: " + e.getMessage());
            } catch (ExecutionException e) {
                log.warn("One of the fighters is breaking the rules: " + e.getMessage());
            }
        }
    }

    public void endBattles() {
        executorService.shutdown();
    }

    private Superhero fight(Superhero firstSuperhero, Superhero secondSuperhero) {
        int totalPowerOfFirstSuperHero = firstSuperhero.getTotalPower();
        int totalPowerOfSecondSuperHero = secondSuperhero.getTotalPower();

        if (totalPowerOfFirstSuperHero > totalPowerOfSecondSuperHero) {
            return firstSuperhero;
        } else {
            return secondSuperhero;
        }
    }
}
