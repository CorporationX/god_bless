package derschrank.sprint04.task10.bjstwo_50592;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    private static final int COUNT_OF_HEROES = 32;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SuperheroBattle battle = new SuperheroBattle();

        List<Superhero> heroes = SuperheroBattleService.getHeroes(COUNT_OF_HEROES);

        List<PairToFight<Superhero>> pairsToFight;
        List<Future<PairToFight<Superhero>>> futures;

        int round = 0;
        while (heroes.size() > 1) {
            System.out.printf("ROUND #%d. Begin!%n", round);
            pairsToFight = SuperheroBattleService.generatePairsToFight(heroes);
            futures = battle.runCompetitions(pairsToFight);
            heroes = SuperheroBattleService.getWinnersFromFutures(futures);
            System.out.printf("ROUND #%d. Ended!%n%n", round++);
        }

        battle.endBattle();
        System.out.println("BATTLE ENDED");
    }


}
