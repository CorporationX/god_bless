package derschrank.sprint04.task10.bjstwo_50592;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class SuperheroBattle {
    private static final int TIME_FOR_FIGHT_MILLIS = 1000;
    private static final int SIZE_OF_THREADPOOL = 10;
    private static final int DEFAULT_AWAIT_FOR_EXECUTOR_SEC = 60;

    private final ExecutorService executor;

    public SuperheroBattle() {
        executor = Executors.newFixedThreadPool(SIZE_OF_THREADPOOL);
    }

    public List<Future<PairToFight<Superhero>>> runCompetitions(List<PairToFight<Superhero>> pairsOfHeroes) {
        return pairsOfHeroes.stream().map(this::fightTask).toList();
    }

    private Future<PairToFight<Superhero>> fightTask(PairToFight<Superhero> pairOfTwoHeroes) {
        return executor.submit(() -> {
            pairOfTwoHeroes.setWinner(
                    fight(pairOfTwoHeroes)
            );

            SuperheroBattleService.toSleep(TIME_FOR_FIGHT_MILLIS);
            SuperheroBattleService.printResultOfFight(pairOfTwoHeroes);
            return pairOfTwoHeroes;
        });
    }

    private Optional<Superhero> fight(PairToFight<Superhero> pairOfTwoHeroes) {
        Superhero left = pairOfTwoHeroes.getLeft();
        Superhero right = pairOfTwoHeroes.getRight();
        double agility = (
                (left.agility() + SuperheroBattleService.goodluckPoints(left.agility()))
                - (right.agility() + SuperheroBattleService.goodluckPoints(right.agility()))
        );
        double strength = (
                (left.strength() + SuperheroBattleService.goodluckPoints(left.strength()))
                - (right.strength() + SuperheroBattleService.goodluckPoints(right.strength()))
        );

        double total = agility + strength;
        if (total == 0) {
            return Optional.empty();
        } else if (total > 0) {
            return Optional.of(left);
        } else {
            return Optional.of(right);
        }
    }

    public void endBattle() {
        executor.shutdown();
        try {
            executor.awaitTermination(DEFAULT_AWAIT_FOR_EXECUTOR_SEC, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
