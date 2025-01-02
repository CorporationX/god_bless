package derschrank.sprint04.task07.bjstwo_50256;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        List<Robot> robots = BattleService.getRobots();

        int round = 1;
        List<Future<Fighting>> results;
        List<Optional<Robot>> winners;
        while (robots.size() > 1) {
            System.out.println("ROUND #: " + round + ". BEGIN!!!");
            results = BattleService.letsFightAllRobots(battle, robots);

            winners = new ArrayList<>();
            for (Future<Fighting> result : results) {
                winners.add(BattleService.printResultOfFightAndGetWinner(result));
            }

            robots = winners.stream().filter(Optional::isPresent).map(Optional::get).toList();

            System.out.println("ROUND #: " + round + ". ENDED!!!\n");
            round++;
        }

        battle.endBattle();
    }



}
