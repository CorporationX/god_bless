package faang.school.godbless.BJS2_24614;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();

            if (winner == null) {
                System.out.println("Ничья");
            } else {
                System.out.println("Победитель битвы: " + winner.getName());
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        battle.shutdown();
    }
}
