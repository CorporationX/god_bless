package sprint_4.sprint_4_1_async_future.starWarsArena_38342;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        try {
            Future<Robot> winnerFuture = battle.fight(r2d2, c3po);
            Robot winner = battle.fight(winnerFuture.get(), bb8).get();
            log.info("Победитель битвы: {}", winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error: {}", e.getMessage());
        }
        battle.shutdown();
    }
}
