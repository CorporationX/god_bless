package faang.school.godbless.starwars_arena;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Robot r3d3 = new Robot("R3-D3", 10, 7);
        Robot c4po = new Robot("C-4PO", 8, 10);

        Future<Robot> firstBattleWinnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> secondBattleWinnerFuture = battle.fight(r3d3, c4po);
        battle.closeCandidateAccept();

        try {
            Robot firstWinner = firstBattleWinnerFuture.get();
            System.out.println("Победитель первой битвы: " + firstWinner.getName());

            Robot secondWinner = secondBattleWinnerFuture.get();
            System.out.println("Победитель второй битвы: " + secondWinner.getName());
        } catch (InterruptedException e) {
            log.warn("Fighting was interrupted: " + e.getMessage());
            log.warn("We cannot continue battle");
        } catch (ExecutionException e) {
            log.warn("Caught an exception during fighting" + e.getMessage());
            log.warn("We cannot continue battle");
        }
    }
}
