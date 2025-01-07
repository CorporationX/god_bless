package school.faang.bjs250304;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 8, 6);

        Future<Robot> firstWinnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> secondWinnerFuture = battle.fight(r2d2, bb8);

        try {
            Robot firstWinner = firstWinnerFuture.get();
            System.out.println("First fight winner: " + firstWinner.getName());

            Robot secondWinner = secondWinnerFuture.get();
            System.out.println("Second fight winner: " + secondWinner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.toString());
        }

        battle.shutdown();
    }
}
