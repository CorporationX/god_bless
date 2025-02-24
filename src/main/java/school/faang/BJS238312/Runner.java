package school.faang.BJS238312;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        Robot winner = null;
        try {
             winner = winnerFuture.get();
        } catch (InterruptedException | ExecutionException e) {
             log.error("Не удалось получить победителя {}", e.getMessage());
        }

        if (winner != null) {
            log.info("Победитель битвы: {} ", winner.getName());
        } else {
            log.info("Где робот?");
        }

        battle.shutDown();
    }
}
