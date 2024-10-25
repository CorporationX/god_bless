package school.faang.starwarsarena;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> firstBattle = battle.fight(r2d2, c3po);

        try {
            Robot firstWinner = firstBattle.get();
            Future<Robot> secondBattle = battle.fight(firstWinner, bb8);
            Robot secondWinner = secondBattle.get();
            log.info("The winner of the battle between {} and {} is {}", r2d2.getName(), c3po.getName(), firstWinner.getName());
            log.info("The winner of the battle between {} and {} is {}", firstWinner.getName(), bb8.getName(), secondWinner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Caught exception: {}", e);
        }
        
        battle.shutdown();
    }
}
