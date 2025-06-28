package school.faang.bjs2_82479;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            log.info("Победитель битвы: {}", winner.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при выполнении битвы", e);
        } catch (ExecutionException e) {
            log.error("Ошибка при выполнении битвы", e);
        }

        battle.shutdown();
    }
}