package school.faang.sprint4.bjs_50315;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class StarWarsArena {
    private static final String MESSAGE_OF_THREAD_INTERRUPTED = "Поток был прерван";

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);
        Robot t2x2 = new Robot("T2X2", 10, 2);

        try {
            Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po);
            Future<Robot> winnerFuture2 = battle.fight(bb8, t2x2);
            Future<Robot> winnerFuture3 = battle.fight(winnerFuture1.get(), winnerFuture2.get());

            Robot winner = winnerFuture3.get();
            log.info("Победитель битвы: {}", winner.name());
        } catch (InterruptedException | ExecutionException e) {
            log.info(MESSAGE_OF_THREAD_INTERRUPTED);
            Thread.currentThread().interrupt();
        }

        battle.getExecutor().shutdown();
    }
}
